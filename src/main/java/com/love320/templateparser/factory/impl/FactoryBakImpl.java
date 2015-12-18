/**
 * Copyright (c) 2010-2011 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.factory.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.love320.templateparser.factory.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 工厂
 * */


public class FactoryBakImpl implements Factory {

    private final static Logger logger = LoggerFactory.getLogger(FactoryBakImpl.class);

	/*单例化
	 * */
	private FactoryBakImpl(){};//私有构造
	
	private static class factoryImplSing{
		private static FactoryBakImpl factoryImpl = new FactoryBakImpl();
	}
	
	public static FactoryBakImpl getFactoryImpl(){
		FactoryBakImpl factoryImpl = factoryImplSing.factoryImpl;
		factoryImpl.configPath("love320Factory.properties");
		return factoryImpl;
	}
	
	public static FactoryBakImpl getFactoryImpl(String configPath){
		FactoryBakImpl factoryImpl = factoryImplSing.factoryImpl;
		factoryImpl.configPath(configPath);
		return factoryImpl;
	}
	
	public static FactoryBakImpl getFactoryImplXML(String configPath){
		FactoryBakImpl factoryImpl = factoryImplSing.factoryImpl;
		factoryImpl.configXMLPath(configPath);
		return factoryImpl;
	}
	
	//单例化 end
	
	private Map<String, Object> data = new HashMap<String, Object>(); //缓存  
	private static String conStr ; 
	private static Properties prop = new Properties();
	private static Element docroot ;
	
	@Override
	public Object getbean(String beanName) {
		Object object = data.get(beanName);
		if(object != null){
			return object ;
		}else{
			object = procreationXML(beanName);
			data.put(beanName, object);
			return object;
		}
		
	}


    //递归生成对象
	private Object procreation(String beanName){
		
		String objectclassname = configGetClassName(beanName);

		Object beanObject = null;
		try {
			if(objectclassname != null){
				beanObject = Class.forName(objectclassname).newInstance();
			}
		} catch (InstantiationException e) {
            logger.error("InstantiationException",e);
		} catch (IllegalAccessException e) {
            logger.error("IllegalAccessException",e);
		} catch (ClassNotFoundException e) {
            logger.error("ClassNotFoundException",e);
		}
		return beanObject;
	}
	
	//获取beanName 对应的类名
	private String configGetClassName(String beanName){
		return prop.getProperty(beanName);
	}

	private void configPath(String configPath) {
		InputStream in = this.getClass().getResourceAsStream("/"+configPath);
		try {
			prop.load(in);
		} catch (IOException e) {
            logger.error("IOException",e);
		}
	}
	
	private void configXMLPath(String configPath) {
		SAXReader sax = new SAXReader();
		try {
			Document document= sax.read(configPath);
			docroot = document.getRootElement();
		} catch (DocumentException e) {
            logger.error("DocumentException",e);
		}
	}
	
	//递归生成对象
	private Object procreationXML(String beanName){
		List ls = docroot.selectNodes("/beans/bean");
		Object object = null;
		for(int i = 0 ; i < ls.size();i++){
			Element element = (Element) ls.get(i);
			if(element.attributeValue("id").equals(beanName)){
			try {
				object = Class.forName(element.attributeValue("class")).newInstance();
				
			} catch (InstantiationException e) {
                logger.error("InstantiationException",e);
			} catch (IllegalAccessException e) {
                logger.error("IllegalAccessException",e);
			} catch (ClassNotFoundException e) {
                logger.error("ClassNotFoundException",e);
			}
		}
		}
		return object;
	}
	
	
	
}
