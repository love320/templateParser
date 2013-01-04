package com.love320.templateparser.templateprocess;

import java.io.File;
import java.util.Map;

/**
 * 模板核心处理器
 * 模板解释接口
 * */
public interface TemplateProcess {
	String get(String path);//从指定路径模板解释
	String get(File file);//从文件对象模板解释
	String get(String path,Map messageMap);//从指定路径模板解释带参数
	String get(File file,Map messageMap);//从文件对象模板解释带参数
}
