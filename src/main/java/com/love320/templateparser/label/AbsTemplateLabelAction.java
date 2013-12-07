 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.label;

import java.util.Map;

import com.love320.templateparser.user.bean.SystemMap;

/** 
 * @ClassName: AbsTemplateLabelAction 
 * @Description: TODO
 * @author love320.com
 * @date 2012-6-19 下午08:27:50 
 *  模板 标签action基础抽象类
 */
public abstract class AbsTemplateLabelAction implements LabelAction {

	@Override
	public Map<String, Object> action(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String template(String tem, Map<String, Object> data) {
		return exec(data,SystemMap.DATA);
	}
	

	//处理模板业务
	protected abstract String exec(Map renderMap,Map systemMap);
	
}
