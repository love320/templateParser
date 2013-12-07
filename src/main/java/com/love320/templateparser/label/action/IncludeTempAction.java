package com.love320.templateparser.label.action;

import java.util.Map;

import com.love320.templateparser.io.FileToString;
import com.love320.templateparser.label.AbsTemplateLabelAction;


/**
 * 引用指定文件内容标签
 * @author Administrator
 *
 */
public class IncludeTempAction extends AbsTemplateLabelAction {
	
	private FileToString fileToString ;//文件获取对象

	public void setFileToString(FileToString fileToString) {
		this.fileToString = fileToString;
	}

	@Override
	protected String exec(Map renderMap, Map systemMap) {
		String dir = (String)renderMap.get("dir");
		String name = (String)renderMap.get("name");
		
		if(dir == null || name == null) return "";
		String path = dir+name;
		return fileToString.get(path);//从文件中读取内容到字符串中
	}



}
