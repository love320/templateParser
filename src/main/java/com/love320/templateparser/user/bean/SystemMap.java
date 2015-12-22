 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.user.bean;

import java.util.HashMap;
import java.util.Map;

import com.love320.templateparser.util.MD5;

/** 
 * @ClassName: SystemMap 
 * @Description: TODO
 * @author love320.com
 * @date 2012-6-16 下午04:50:42 
 *  
 *  模板解析系统全局变量
 */
public class SystemMap {
	public static Map DATA = new HashMap<String, Object>();
	private static String KEYNAME = "love320.com.ksdjfwoieicxnbc,lksdjfow.SystemMap";

	public static Object get(String key){
		return DATA.get(key);
	}
	
	public static void put(String key,Object object){
		DATA.put(key, object);
	}
}
