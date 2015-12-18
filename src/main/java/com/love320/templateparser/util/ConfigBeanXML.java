/**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.util;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: ConfigBeanXML
 * @Description: TODO
 * @author love320.com
 * @date 2012-6-16 下午05:21:32 合并多个配置文件
 */
public class ConfigBeanXML {

    private final static Logger logger = LoggerFactory.getLogger(ConfigBeanXML.class);

	public static Element action(String config, String... paths) {
		Document document = null;
		document = getXML(FileUtil.getJar(config));//主配置文件

		// 以第一个为首配置文件整理后面的所有配置文件
		if(paths != null){
			for (String path : paths) {
				if (path != null) {
					document = merger(document, getXML(FileUtil.get(path)));// 一个个整理配置文件
				}
			}
		}

		return document.getRootElement();
	}

	// 将第二个配置文件合成到第一个中,重复则替换
	private static Document merger(Document document, Document doc) {
		Iterator documentIter = selectNodes(document,"/beans");//选择对象
		if(documentIter.hasNext()){//对象有有效
			Element documentElement = (Element) documentIter.next();//获取有效的Element对象
	
			Iterator dociter = selectNodes(doc,"/beans/bean");//选择对象
			while (dociter.hasNext()) {//遍例所有
				Element docElement = (Element) dociter.next();//获取有效的Element对象
				deleteElement(document,docElement.attributeValue("id"));//删除节点
				documentElement.add(docElement.createCopy());//添加到主配置文件中,以创建副本方法添加
			}
		}
		return document;
	}
	
	//删除指定的所有信息节点
	private static void deleteElement(Document document,String beanId){
		Iterator documentIter = selectNodes(document,"/beans/bean[@id='"+beanId+"']");//选择对象
		while(documentIter.hasNext()){
			Element element = (Element) documentIter.next();//获取有效的Element对象
			element.detach();//删除节点
		}
	}

	//获取配置文件指定的对象信息列表并转为迭代
	private static Iterator selectNodes(Document document,String xpath){
		List documentList = document.selectNodes(xpath);//获取beans节点列表
		Iterator documentIter = documentList.iterator();//迭代
		return documentIter;
	}
	
	// 获取xml
	private static Document getXML(InputStream is) {
		SAXReader sax = new SAXReader();
		Document document = null;
		try {
			document = sax.read(is);// 读取
		} catch (DocumentException e) {
            logger.error("DocumentException",e);
		}
		return document;
	}
}
