package com.love320.templateparser;

import java.util.HashMap;
import java.util.Map;

import com.love320.templateparser.factory.AppFactory;
import com.love320.templateparser.factory.Factory;
import com.love320.templateparser.templateprocess.TemplateProcess;
import com.love320.templateparser.user.bean.SystemMap;
import com.love320.templateparser.util.AppPath;

import junit.framework.TestCase;

public class DemoTest extends TestCase {
	
	private String dir = AppPath.path()+"demo/";
	
	/**
	 * 启动解析功能
	 */
	private TemplateProcess templateProcess(){
		AppFactory appfactory = AppFactory.getAppFactory();
		Factory factory = appfactory.getFactory();
		TemplateProcess templateProcess = (TemplateProcess)factory.getbean("templateProcess");
		return templateProcess;
	}
	
	/**
	 * 定义标签 类
	 */
	public void testLabelAction(){
		AppFactory appfactory = AppFactory.getAppFactory();
		appfactory.setConPath("Xconfig.xml");//指定配置文件
		Factory factory = appfactory.getFactory();
		TemplateProcess tp = (TemplateProcess)factory.getbean("templateProcess");
		String temp = tp.get(dir+"Label.txt");
		System.out.println(temp);
	}
	
	
	/**
	 * Helloworld 演示
	 */
	public void testHelloworld(){
		TemplateProcess tp = templateProcess();
		String temp = tp.get(dir+"Helloworld.txt");
		System.out.println(temp);
	}
	
	/**
	 * 导入参数
	 */
	public void testParameter(){
		Map themap = new HashMap<String,Object>();
		themap.put("a", 100);
		themap.put("b", "OK");
		TemplateProcess tp = templateProcess();
		String temp = tp.get(dir+"Parameter.txt",themap);
		System.out.println(temp);
	}
	
	/**
	 * 添加 全局参数
	 */
	public void testSystemMap(){
		SystemMap.DATA.put("over", "参数A");
		TemplateProcess tp = templateProcess();
		String temp = tp.get(dir+"SystemMap.txt");
		System.out.println(temp);
	}
	

}
