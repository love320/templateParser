package com.love320.templateparser.templateprocess;

import java.io.File;
import java.util.Map;

/**
 * 模板核心处理器
 * 模板解释接口
 * */
public interface TemplateProcess {

    String get(File file);//从文件对象模板解释
    String get(String path);//从指定路径模板解释
    String get(String dir,File file);//从指定模板目录和文件解释
    String get(String dir,String name);//从指定模板目录和文件名解释

	String get(File file,Map messageMap);//从文件对象模板解释带参数
    String get(String path,Map messageMap);//从指定路径模板解释带参数
    String get(String dir,File file,Map messageMap);//从指定模板目录和文件解释带参数
    String get(String dir,String name,Map messageMap);//从指定模板目录和文件名解释带参数

    String getByText(String text);//从指定文件内容模板解释
    String getByText(String text,Map messageMap);//从指定文件内容解释带参数
    String getByText(String dir,String text,Map messageMap);//从指定模板目录和文件内容解释带参数

}
