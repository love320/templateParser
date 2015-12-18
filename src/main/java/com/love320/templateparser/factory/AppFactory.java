/**
 * Copyright (c) 2010-2011 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import com.love320.templateparser.factory.entity.BeanString;
import com.love320.templateparser.factory.impl.FactoryBeanImpl;
import com.love320.templateparser.util.ConfigBeanXML;
import com.love320.templateparser.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppFactory {

    private final static Logger logger = LoggerFactory.getLogger(AppFactory.class);
	
	/*单实例化
	 * */
	private AppFactory(){};//私有构造
	
	private static class AppFactorySing{
		private static AppFactory appFactory = new AppFactory();
	}
	
	public static AppFactory getAppFactory(){
		return AppFactorySing.appFactory;
	}
	
	//单实例化 end
	private Factory factory;
	private String[] conPath ;
	private static Element DOCROOT ;
	
	public void setConPath(String...pathS) {
		this.conPath = pathS;
	}
	
	private void xmlStr(){
		SAXReader sax = new SAXReader();
		try {
			Document document= sax.read(FileUtil.get(conPath[0]));
			DOCROOT = document.getRootElement();
		} catch (DocumentException e) {
            logger.error("DocumentException",e);
		}
	}

	public synchronized Factory getFactory() {
		if(factory == null){
			//工厂一
			//factory = new FactoryImpl(DOCROOT).factoryInit();//实例化工厂类并初始化
			
			//工厂二
			BeanString bs = new BeanString();
			bs.setName("beanfactory");
			bs.setClassName("com.love320.templateparser.factory.impl.BeanFactoryImpl");
			
			//实例化工厂类一
			/*
			if(conPath != null){
				factory = new FactoryBeanImpl().factoryInit(bs,DOCROOT);//实例化工厂类并初始化
			}else{//使用系统默认的配置文件
				conPath = AppFactory.class.getResource("factoryconfig.xml").toString();//设置默认文件路径
				xmlStr();//读取配置文件到 Element DOCROOT
				factory = new FactoryBeanImpl().factoryInit(bs,DOCROOT);//实例化工厂类并初始化
			}
			*/
			
			//实例化工厂类二
			DOCROOT = ConfigBeanXML.action("factoryConfig.xml",conPath);
			factory = new FactoryBeanImpl().factoryInit(bs,DOCROOT);//实例化工厂类并初始化
			
		}
		return factory;
	}
	
}
