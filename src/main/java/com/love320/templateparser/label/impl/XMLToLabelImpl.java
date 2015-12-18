 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.label.impl;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.love320.templateparser.factory.entity.Label;
import com.love320.templateparser.label.XMLToLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 /**
 * @ClassName: XMLToLabelImpl 
 * @Description: TODO
 * @author love320.com
 * @date 2012-5-6 下午04:03:47 
 *  
 */
public class XMLToLabelImpl implements XMLToLabel {

    private final static Logger logger = LoggerFactory.getLogger(XMLToLabelImpl.class);

	/* (non-Javadoc)
	 * @see com.love320.templateparser.label.XMLToLabel#get(java.lang.String)
	 */
	@Override
	public List<Label> get(String xmlstr) {
		List<Label> labeList = new ArrayList<Label>();
		try {
			Document  document = DocumentHelper.parseText(xmlstr);//从string 转换为xml
			Element docroot = document.getRootElement();//获取Element
			List ls = docroot.selectNodes("/root/content/item");//获取item对象列表
			for(int i = 0 ; i < ls.size();i++){//遍例
				Element element = (Element) ls.get(i);//获取一个对象
				String type = element.attributeValue("type");//获取对象类型
				Label label = new Label();//实例化标签对象
				label.setType(type);//设置对象类型
				label.setTemplate(element.getText());//设置对象内容
				labeList.add(label);//加入列表中
				/*
				if(type.equals("label")){//标签类型
					logger.info("label:"+element.getText());
				}else if(type.equals("symbols")){//符号类型
					logger.info("symbols:"+element.getText());
				}else{//默认字符串
					logger.info(element.getText());
				}
				*/
			}
		} catch (DocumentException e) {
            logger.error("DocumentException",e);
		}
		return labeList;
	}

}
