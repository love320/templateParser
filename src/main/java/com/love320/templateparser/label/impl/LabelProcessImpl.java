 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.label.impl;

import java.util.HashMap;
import java.util.Map;
import com.love320.templateparser.factory.Factory;
import com.love320.templateparser.factory.LabelBeanFactory;
import com.love320.templateparser.factory.entity.LabelBean;
import com.love320.templateparser.json.JSONException;
import com.love320.templateparser.json.JSONObject;
import com.love320.templateparser.label.LabelAction;
import com.love320.templateparser.label.LabelProcess;
import com.love320.templateparser.label.Synthesis;
import com.love320.templateparser.user.bean.SystemMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 /**
 * @ClassName: LabelProcessImpl 
 * @Description: TODO
 * @author love320.com
 * @date 2012-5-6 下午07:48:26 
 *  
 */
public class LabelProcessImpl implements LabelProcess {

    private final static Logger logger = LoggerFactory.getLogger(LabelProcessImpl.class);
	
	private LabelBeanFactory labelBeanFactory;//标签对应 的信息工厂
	private Factory factoryService;//bean工厂
	private Synthesis synthesis;//模板引擎  ,数据与模板合成
	
	public void setLabelBeanFactory(LabelBeanFactory labelBeanFactory) {
		this.labelBeanFactory = labelBeanFactory;
	}

	public void setFactoryService(Factory factoryService) {
		this.factoryService = factoryService;
	}
	
	public void setSynthesis(Synthesis synthesis) {
		this.synthesis = synthesis;
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.label.LabelProcess#get(java.lang.String)
	 */
	@Override
	public String get(String labelName,Map messageMap) {
		LabelBean labelBean = labelBeanFactory.get(labelName);//以标签名获取标签信息对象装载体
		LabelAction labelAction = (LabelAction)factoryService.getbean(labelBean.getBean());//获取标签处理对象
		try {
			JSONObject jsonbject = new JSONObject(labelBean.getParameters());//获取配置文件参数
			messageMap.putAll(jsonbject.getMap());//获取标签配置文件数据map并加入
		} catch (JSONException e) {
            logger.error("JSONException",e);
		}
		messageMap.put("systemMap", SystemMap.DATA);//加入系统数据map
		Map<String, Object> data = labelAction.action(messageMap);//标签处理后获取的数据map
		String template = labelAction.template(labelBean.getTemplate(),data);//标签处理后获取的模板信息
		return synthesis.process(data, template);
	}

}
