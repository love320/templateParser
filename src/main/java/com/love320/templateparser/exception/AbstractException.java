 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.exception;

import java.util.Locale;

import com.love320.templateparser.i18n.MessageSource;

/** 
 * @ClassName: Love320Exception 
 * @Description: TODO
 * @author love320.com
 * @date 2012-8-4 下午08:15:18 
 *  
 */
public abstract class AbstractException extends Exception {

    /** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;

	/** 错误码 */
    private String code;

    /** 错误描述 */
    private String message;

    /** 国际化参数 */
    private Object[] arguments;
    
    /** 功能区*/
    protected abstract String ModuleMethod();
    
    public AbstractException(String code){
    	this.code = code;
    }
    
    public AbstractException(String code,String message){
    	this.code = code;
    	this.message = message;
    }
    
    public AbstractException(String code,Object[] arguments){
    	this.code = code;
    	this.arguments = arguments;
    }
    
    public AbstractException(String code,String message,Object[] arguments){
    	this.code = code;
    	this.message = message;
    	this.arguments = arguments;
    }
    
    public AbstractException(String code, Throwable throwable){
    	super(throwable);
    	this.code = code;
    }
    
    public AbstractException(String code,String message, Throwable throwable){
    	super(throwable);
    	this.code = code;
    	this.message = message;
    }
    
    public AbstractException(String code,String message,Object[] arguments, Throwable throwable){
    	super(throwable);
    	this.code = code;
    	this.message = message;
    	this.arguments = arguments;
    }
    
    public String message(){
    	
    	if(message != null){
    		return ExceptionMessageUtil.E.message(ModuleMethod(), code,message);
    	}
    	
    	if(arguments != null){
    		return ExceptionMessageUtil.E.message(ModuleMethod(), code,arguments);
    	}
    	
    	return ExceptionMessageUtil.E.message(ModuleMethod(), code);
    }
    
    public String message(Locale locale){
 	   return ExceptionMessageUtil.E.message(ModuleMethod(), code, arguments, locale);
    }
    
    public String message(String module){
    	return ExceptionMessageUtil.E.message(module, code,message);
    }
    
    public String message(String module, Locale locale){
    	return ExceptionMessageUtil.E.message(module, code, arguments, locale);
    }
    
}
