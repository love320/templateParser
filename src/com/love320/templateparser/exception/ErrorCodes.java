 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.exception;

/** 
 * @ClassName: ErrorCodes 
 * @Description: TODO
 * @author love320.com
 * @date 2012-8-5 上午12:06:07 
 *  
 */
public interface ErrorCodes {
	
	/**
	 * 程序工作区
	 * 号从1-9999
	 * */
	
	/**当前系统*/
	String MODULE_CODE_SYS = "LOVE320-TEMPLATEPARSER-SYSTEM";
	
	/**工厂区 */
	String MODULE_CODE_1 = "LOVE320-TEMPLATEPARSER-FACTORY";
	
	/**IO区*/
	String MODULE_CODE_2 = "LOVE320-TEMPLATEPARSER-IO";

	/**缓存区*/
	String MODULE_CODE_3 = "LOVE320-TEMPLATEPARSER-CACHE";
	
	/**模板解析区*/
	String MODULE_CODE_4 = "LOVE320-TEMPLATEPARSER-TEMPLATEPARSER";
	
	/**标签区*/
	String MODULE_CODE_5 = "LOVE320-TEMPLATEPARSER-LABEL";
	
	/**外部信息区*/
	String MODULE_CODE_6 = "LOVE320-USERINFO-LABEL";
	
	/**
	 * 错误码
	 * 码10001-90000
	 * */
	
	/**自定义信息内容*/
	String ERROR_CODE_10001 = "10001";
	
	/**实例BeanString模式{0}对象失败*/
	String ERROR_CODE_10002 = "10002";
	
	String ERROR_CODE_10003 = "10003";
	
	String ERROR_CODE_10004 = "10004";
	
	String ERROR_CODE_10005 = "10005";
	
	String ERROR_CODE_10006 = "10006";
	
	String ERROR_CODE_10007 = "10007";
	
	String ERROR_CODE_10008 = "10008";
	
	String ERROR_CODE_10009 = "10009";
	
	String ERROR_CODE_10010 = "10010";
	
	String ERROR_CODE_10011 = "10011";
	
	String ERROR_CODE_10012 = "10012";

}
