 /**
 * Copyright (c) 2010-2011 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.factory.impl;

import java.util.List;

import org.dom4j.Element;
import org.dom4j.Node;

import com.love320.templateparser.cache.Cache;
import com.love320.templateparser.exception.FactoryException;
import com.love320.templateparser.factory.BeanFactory;
import com.love320.templateparser.factory.entity.BeanString;
import com.love320.templateparser.util.Log;

/** 
 * @ClassName: BeanFactoryImpl 
 * @Description: TODO
 * @author love320.com
 * @date 2012-4-15 下午05:01:08 
 *  
 */
public class BeanFactoryCacheImpl implements BeanFactory {

	private Element docroot ;
	private Cache cache;
	private String cacheKey = "WWW.LOVE320.COMKeyksdjfksdjglksjdfkdhsgksdjfkljsdlkfj<bean>:";// 缓存建值(头)
	
	public BeanString getBeanString(String name){
		BeanString bs = (BeanString)cache.getObject(cacheKey+name);
		if(bs == null){
			try {
				bs = action(name);
			} catch (Exception e) {
				FactoryException fe = new FactoryException(new String[]{name});
				Log.LOGGER.warn(fe.message(), this);
				e.printStackTrace();
			}
			bs = action(name);	
			cache.putObject(cacheKey+name, bs);
		}
		return bs;
	}
	
	private BeanString action(String name){
		BeanString beanString = new BeanString();//实例装载bean信息对象
		beanString.setName(name);//设置bean信息name
		Node node = docroot.selectSingleNode("/beans/bean[@id='"+name+"']/@class"); //读取id为name的class属性数据信息
		beanString.setClassName(node.getText());//设置bean信息className
		Node beanScope = docroot.selectSingleNode("/beans/bean[@id='"+name+"']/@scope"); //读取id为name的scope属性数据信息
		if(beanScope != null ) beanString.setScope(beanScope.getText());//设置bean信息scope

		List ls = docroot.selectNodes("/beans/bean[@id='"+name+"']/property");//获取当前实例依赖类
		for(int i = 0 ; i < ls.size();i++){
			Element element = (Element) ls.get(i);
			String propertyName = element.attributeValue("name");//注入beanName
			
			Node propertyBeanNode = docroot.selectSingleNode("/beans/bean[@id='"+name+"']/property[@name='"+propertyName+"']/ref/@bean");
			if(propertyBeanNode != null){
				//增加反射注入类 成员名和beanId
				String[] refs = {null,null};
				refs[0] = propertyName;
				refs[1] =  propertyBeanNode.getText();
				beanString.getRefList().add(refs);
			}

			Node propertyValueNode = docroot.selectSingleNode("/beans/bean[@id='"+name+"']/property[@name='"+propertyName+"']/value");
			if(propertyValueNode != null){
				//增加反射注入类 成员名和常量值
				String[] values = {null,null};
				values[0] = propertyName;
				values[1] =  propertyValueNode.getText();
				beanString.getValueList().add(values);
			}
	
		}
		return beanString;
	}

	public void setDocroot(Element docroot) {
		this.docroot = docroot;
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}
	
	

}
