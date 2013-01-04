 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.label.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.love320.templateparser.factory.entity.LabelBean;
import com.love320.templateparser.label.LabelBeanDao;
import com.love320.templateparser.util.AppPath;

/** 
 * @ClassName: LabelManagerImpl 
 * @Description: TODO
 * @author love320.com
 * @date 2012-6-23 下午06:54:21 
 *  
 */
public class LabelBeanDaoImpl implements LabelBeanDao {
	
	private String configPath; //标签配置文件路径
	private Element DOCROOT ;//标签配置文件
	
	public void setConfigPath(String confpath) {
			
			this.configPath = appPath(confpath);//应用目录
	
			SAXReader sax = new SAXReader();
			try {
				Document document= sax.read(this.configPath);
				DOCROOT = document.getRootElement();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
	}
	
	protected String appPath(String confpath){
		return AppPath.PATH+confpath;
	}
	
	//获取Element对象
	private Element docExtractName(String labelName){
		//以标签名，获取Element对象
		Element labelElement = (Element) DOCROOT.selectSingleNode("/labels/label[@name='"+labelName.trim()+"']");
		return labelElement;
	}
	
	private boolean upSeting(LabelBean labelBean){
		Element docrootElement = (Element) DOCROOT.selectSingleNode("/labels");
		Element labelElement = docrootElement.addElement("label");
		return upSeting(labelBean,labelElement);
	}
	
	//labelbean给element赋值
	private boolean upSeting(LabelBean labelBean,Element labelElement){
		//获取 labelBean信息
		String name = labelBean.getName();
		String parameters = labelBean.getParameters();
		String template = labelBean.getTemplate();
		String bean = labelBean.getBean();
		String note = labelBean.getNote();
		
		//设置Element信息
		labelElement.addAttribute("name", name);
		labelElement.addElement("parameters").addCDATA(parameters);
		labelElement.addElement("template").addCDATA(template);
		labelElement.addElement("bean").setText(bean);
		labelElement.addElement("note").setText(note);
		
		return true;
	}
	
	//element给labelbean赋值
	private boolean upSeting(Element labelElement,LabelBean labelBean){
		//获取 Element信息
		String name = labelElement.attributeValue("name");
		String parameters = labelElement.elementText("parameters");
		String template = labelElement.elementText("template");
		String bean = labelElement.elementText("bean");
		String note = labelElement.elementText("note");
		
		//设置LabelBean信息
		labelBean.setName(name);
		labelBean.setParameters(parameters);
		labelBean.setTemplate(template);
		labelBean.setBean(bean);
		labelBean.setNote(note);
		return true;
	}
	
	//写入配置并保存
	private boolean XMLWriter(){
		try {
			URI configURI = new URI(configPath);//实例化文件对象
			OutputFormat format = OutputFormat.createPrettyPrint();//格式化
			format.setEncoding("UTF-8");//设置编码
			XMLWriter output = new XMLWriter(new FileWriter(new File(configURI)),format);//写入操作对象
			output.write(DOCROOT.getDocument());//写入
			output.close();//关闭对象
			
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.factory.LabelBeanFactory#get(java.lang.String)
	 */
	@Override
	public LabelBean get(String labelName) {
		LabelBean labelBean = new LabelBean();//实例标签信息装载体
		//配置文件获取xml信息
		Element labelElement = (Element) docExtractName(labelName);
		if(labelElement != null){
			upSeting(labelElement,labelBean);//element给labelbean赋值
		}else{
			labelBean.setName(labelName);
		}
		
		return labelBean;
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.label.LabelDao#add(com.love320.templateparser.factory.entity.LabelBean)
	 */
	@Override
	public boolean add(LabelBean labelBean) {
		upSeting(labelBean);//增加
		XMLWriter();//保存
		return true;
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.label.LabelDao#delete(java.lang.String)
	 */
	@Override
	public boolean delete(String labelName) {
		Element element = docExtractName(labelName);//获取对象
		element.detach();//删除对象
		XMLWriter();//保存配置文件
		return true;
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.label.LabelDao#delete(com.love320.templateparser.factory.entity.LabelBean)
	 */
	@Override
	public boolean delete(LabelBean labelBean) {
		return delete(labelBean.getName());//以名称删除
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.label.LabelDao#getAll()
	 */
	@Override
	public List<LabelBean> getAll() {
		List<LabelBean> labelBeanList = new ArrayList();
		
		List list = DOCROOT.selectNodes("/labels/label");
		Iterator iter=list.iterator();
		 while(iter.hasNext()){
			 Element element=(Element)iter.next();
	         LabelBean labelBean = new LabelBean();
	         upSeting(element,labelBean);
	         labelBeanList.add(labelBean);
	    }
		return labelBeanList;
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.label.LabelDao#update(com.love320.templateparser.factory.entity.LabelBean)
	 */
	@Override
	public boolean update(LabelBean labelBean) {
		Element element = docExtractName(labelBean.getName());//获取对象
		element.detach();//删除对象
		upSeting(labelBean);//增加
		XMLWriter();//保存
		return true;
	}



	

}