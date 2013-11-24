/**
 * Copyright (c) 2010-2011 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package test;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;

import com.love320.templateparser.factory.AppFactory;
import com.love320.templateparser.factory.Factory;
import com.love320.templateparser.factory.entity.LabelBean;
import com.love320.templateparser.label.LabelBeanDao;
import com.love320.templateparser.templateprocess.TemplateProcess;
import com.love320.templateparser.user.bean.SystemMap;
import com.love320.templateparser.util.Log;

public class factorytest extends TestCase {
	public void testsysprintln(){
		System.out.println("go");
		Thread.currentThread().getContextClassLoader().getResource("");
		System.out.println(factorytest.class.getClassLoader().getResource(""));
		System.out.println(ClassLoader.getSystemResource(""));
		System.out.println(factorytest.class.getResource("factorytest.config"));
		System.out.println(factorytest.class.getResource("/"));
		System.out.println(new File("").getAbsolutePath());
		System.out.println(System.getProperty("user.dir"));
		System.out.println(this.getClass().getResourceAsStream("/"));
	}
	
	public void testobect(){
		AppFactory appfactory = AppFactory.getAppFactory();
		appfactory.setConPath("Xconfig.xml");
		
		Factory factory = appfactory.getFactory();
		test.A a = (A)factory.getbean("a");
		System.out.println(">>>>>");
		a.print();
		a.getC().print();
		a.getAcsdkfei().privasdf();
		a.getIntk();
		a.getB().get();
		System.out.println(">>>>>获取对象");
		System.out.println(">>>>> end");
	}
	
	public void testobect2(){
		AppFactory appfactory = AppFactory.getAppFactory();
		appfactory.setConPath("Xconfig.xml");
		
		Factory factory = appfactory.getFactory();
		factory.getbean("cc");
		factory.getbean("b");
		factory.getbean("test2");
				
	}
	
	public void testsing(){
		
		AppFactory appfactory = AppFactory.getAppFactory();
		appfactory.setConPath("Xconfig.xml");
		Factory factory = appfactory.getFactory();
		System.out.println(appfactory);
		System.out.println(factory);
		
		AppFactory appfactory2 = AppFactory.getAppFactory();
		appfactory2.setConPath("Xconfig.xml");
		Factory factory2 = appfactory2.getFactory();
		System.out.println(appfactory2);
		System.out.println(factory2);
		
		
	}
	
	public void testBean(){
		AppFactory appfactory = AppFactory.getAppFactory();
		appfactory.setConPath("Xconfig.xml");
		Factory factory = appfactory.getFactory();
		System.out.println(factory.getbean("cache"));
		System.out.println(factory.getbean("csdsc"));
		System.out.println(factory.getbean("csdsc"));
		System.out.println(factory.getbean("csdsc"));
		System.out.println(factory.getbean("csdsc"));
		System.out.println(factory.getbean("csdsc"));
		System.out.println(factory.getbean("cache"));
		System.out.println(factory.getbean("cache"));
		System.out.println(factory.getbean("cache"));
		System.out.println(factory.getbean("cc"));
		System.out.println(factory.getbean("cc"));
		System.out.println(factory.getbean("cc"));
		
	}
	
	
	public void testAddLabelBean(){
		AppFactory appfactory = AppFactory.getAppFactory();
		Factory factory = appfactory.getFactory();
		LabelBeanDao labelBeanDao = (LabelBeanDao)factory.getbean("labelBeanDao");
		
		LabelBean labelBean = labelBeanDao.get("网站关键字");
		labelBean.setName("张迪");
		labelBean.setNote("中国停车位吸肋");
		
		labelBeanDao.add(labelBean);
		
	}
	
	public void testUpdataLabelBean(){
		AppFactory appfactory = AppFactory.getAppFactory();
		Factory factory = appfactory.getFactory();
		LabelBeanDao labelBeanDao = (LabelBeanDao)factory.getbean("labelBeanDao");
		
		LabelBean labelBean = labelBeanDao.get("张迪");
		labelBean.setNote("中国停车位吸肋");
		
		labelBeanDao.update(labelBean);
		
	}
	
	public void testdeleteLabelBean(){
		AppFactory appfactory = AppFactory.getAppFactory();
		Factory factory = appfactory.getFactory();
		LabelBeanDao labelBeanDao = (LabelBeanDao)factory.getbean("labelBeanDao");
		
		LabelBean labelBean = labelBeanDao.get("张迪");
		labelBean.setNote("中国停车位吸肋");
		
		labelBeanDao.delete(labelBean);
		
	}
	
	public void testAllLabelBean(){
		AppFactory appfactory = AppFactory.getAppFactory();
		Factory factory = appfactory.getFactory();
		LabelBeanDao labelBeanDao = (LabelBeanDao)factory.getbean("labelBeanDao");
		List<LabelBean> labelBeanList = labelBeanDao.getAll();
		System.out.println(labelBeanList.get(0).getParameters());
	}
	
	public void testBeanTemplate(){ 
		
		AppFactory appfactory = AppFactory.getAppFactory();
		//appfactory.setConPath("Xconfig.xml",null);//指定配置文件
		Factory factory = appfactory.getFactory();
		TemplateProcess templateProcess = (TemplateProcess)factory.getbean("templateProcess");
		
		SystemMap.DATA.put("zhangdi", "中国人>.s ");
		
		String temp = templateProcess.get("bin/homepage.htm",SystemMap.DATA);
		System.out.println(temp);
		
		//factory.getbean("error");
		Log.LOGGER.info("zhanisd", this);
	}
}
