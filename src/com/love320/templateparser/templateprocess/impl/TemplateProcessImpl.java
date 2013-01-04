package com.love320.templateparser.templateprocess.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.love320.templateparser.factory.entity.Label;
import com.love320.templateparser.io.FileToString;
import com.love320.templateparser.label.LabelParser;
import com.love320.templateparser.label.XMLToLabel;
import com.love320.templateparser.templateprocess.Separation;
import com.love320.templateparser.templateprocess.TemplateProcess;

/**
 * 模板核心处理器
 * */
public class TemplateProcessImpl implements TemplateProcess {
	
	private FileToString fileToString ;//文件获取对象
	private String templateDir = ""; //模板目录
	private Separation separation;//分离器(内容与标签分离)
	private XMLToLabel xmlToLabel;//转换器，从xml数据格式转换为label对象
	private LabelParser labelParser;//标签分析器
	

	public void setTemplateDir(String templateDir) {
		this.templateDir = templateDir;
	}

	public void setFileToString(FileToString fileToString) {
		this.fileToString = fileToString;
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
	public String get(String path) {
		return get(new File(path));
	}

	@Override
	public String get(File file) {
		return get(file,null);
	}

	@Override
	public String get(String path,Map messageMap) {
		return get(new File(path),messageMap);
	}

	@Override
	public String get(File file,Map messageMap) {
		String templateFileStr = fileToString.get(file);//从文件中读取内容到字符串中
		String tempXML = separation.getXML(templateFileStr);//分离内容与标签并以xml管理，返回xml字符串
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
