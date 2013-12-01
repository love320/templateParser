 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.label;

import java.util.Map;

/** 
 * @ClassName: AbstractLabelAction 
 * @Description: TODO
 * @author love320.com
 * @date 2012-6-19 下午08:27:50 
 *  标签action基础抽象类
 */
public abstract class AbstractLabelAction implements LabelAction {
	
	@Override
	public final Map<String, Object> action(Map<String, Object> data) {
		Map<String,Object> systemMap = (Map<String, Object>) data.get("systemMap");//获取系统数据map
		Map<String,Object> renderMap = data;//信息的获取者，也是信息装载体
		return exec(renderMap,systemMap);//处理业务管理数据并返回数据
	}
	
	@Override
	public String template(String tem, Map<String, Object> data) {
		return tem;
	}
	
	//处理业务
	protected abstract Map exec(Map renderMap,Map systemMap);
	
}
