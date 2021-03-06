package com.love320.templateparser.templateprocess.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.love320.templateparser.factory.entity.Label;
import com.love320.templateparser.io.FileToString;
import com.love320.templateparser.label.LabelParser;
import com.love320.templateparser.label.StrToTemplate;
import com.love320.templateparser.label.XMLToLabel;
import com.love320.templateparser.templateprocess.Separation;
import com.love320.templateparser.templateprocess.TemplateProcess;

/**
 * 模板核心处理器
 * */
public class TemplateProcessImpl implements TemplateProcess {

	private FileToString fileToString ;//文件获取对象
	private StrToTemplate strToTemplate;//预分析模板文件内容 
	private Separation separation;//分离器(内容与标签分离)
	private XMLToLabel xmlToLabel;//转换器，从xml数据格式转换为label对象
	private LabelParser labelParser;//标签分析器


	public void setFileToString(FileToString fileToString) {
		this.fileToString = fileToString;
	}

	public void setStrToTemplate(StrToTemplate strToTemplate) {
		this.strToTemplate = strToTemplate;
	}

	public void setSeparation(Separation separation) {
		this.separation = separation;
	}
	
	public void setXmlToLabel(XMLToLabel xmlToLabel) {
		this.xmlToLabel = xmlToLabel;
	}

	public void setLabelParser(LabelParser labelParser) {
		this.labelParser = labelParser;
	}
	

    @Override
    public String get(File file) {
        return get(file,null);
    }

	@Override
	public String get(String path) {
		return get(new File(path));
	}

    @Override
    public String get(String dir, File file) {
        return get(dir,file,null);
    }

    @Override
    public String get(String dir, String name) {
        return get(dir,new File(dir+name));
    }

	@Override
	public String get(String path,Map messageMap) {
		return get(new File(path),messageMap);
	}

    @Override
    public String get(String dir, String name, Map messageMap) {
        return get(dir,new File(dir+name),messageMap);
    }

    @Override
    public String get(File file, Map messageMap) {
        return get(null,file,messageMap);
    }

    @Override
	public String get(String dirPath,File file,Map messageMap) {
		String templateFileStr = fileToString.get(file);//从文件中读取内容到字符串中
        return getByText(dirPath,templateFileStr,messageMap);
	}

    @Override
    public String getByText(String text) {
        return getByText(text,null);
    }

    @Override
    public String getByText(String text, Map messageMap) {
        return getByText(null,text,messageMap);
    }

    @Override
    public String getByText(String dirPath, String text, Map messageMap) {
        String template = strToTemplate.get(text,dirPath);//预处理模板文件，使其为完整的文件
        String tempXML = separation.getXML(template);//分离内容与标签并以xml管理，返回xml字符串
        List<Label> labelList = xmlToLabel.get(tempXML);//从xml数据格式转换为label对象
        labelListMessagee(labelList,messageMap);//标签集合加入信息体
        labelList = labelParser.get(labelList);//标签分析器进行解析
        return labelSToTemplate(labelList);//解析后的标签合并成内容
    }
	
	//解析后的标签合并成内容
	private String labelSToTemplate(List<Label> labelList){
		String template = "";//解析后的装载体
		for(Label label : labelList){
			String str = label.getTemplate();
			if(str.equals("/r/n")){ // (换行)--标记符
				template += "\r\n";// 换行
			}else{
				template += str;//拼接解析后的模板字符串
			}
			
		}
		return template;
	}
	
	//标签集合加入信息体
	private void labelListMessagee(List<Label> labelList,Map messageMap){
		if(messageMap != null){
			for(Label label : labelList){
				label.getMessageMap().putAll(messageMap);//累加装载信息
			}
		}
		
	}

}
