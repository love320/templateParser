 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.log.impl;

import com.love320.templateparser.log.Logger;

/** 
 * @ClassName: LoggerImpl 
 * @Description: TODO
 * @author love320.com
 * @date 2012-8-4 下午06:53:53 
 *  
 */
public class LoggerImpl implements Logger {

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#debug(java.lang.String)
	 */
	@Override
	public void debug(String msg) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#debug(java.lang.String, java.lang.Object)
	 */
	@Override
	public void debug(String msg, Object object) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#debug(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void debug(String msg, Object object1, Object object2) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#debug(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void debug(String msg, Object[] objectArray) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#debug(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void debug(String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#error(java.lang.String)
	 */
	@Override
	public void error(String msg) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#error(java.lang.String, java.lang.Object)
	 */
	@Override
	public void error(String msg, Object object) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#error(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void error(String msg, Object object1, Object object2) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#error(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void error(String msg, Object[] objectArray) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#error(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void error(String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#info(java.lang.String)
	 */
	@Override
	public void info(String msg) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#info(java.lang.String, java.lang.Object)
	 */
	@Override
	public void info(String msg, Object object) {
		// TODO Auto-generated method stub
		String className = object.getClass().getName();
		System.out.println(className+":"+msg);
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#info(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void info(String msg, Object object1, Object object2) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#info(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void info(String msg, Object[] objectArray) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#info(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void info(String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#isDebugEnabled()
	 */
	@Override
	public boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#isErrorEnabled()
	 */
	@Override
	public boolean isErrorEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#isInfoEnabled()
	 */
	@Override
	public boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#isTraceEnabled()
	 */
	@Override
	public boolean isTraceEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#isWarnEnabled()
	 */
	@Override
	public boolean isWarnEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#trace(java.lang.String)
	 */
	@Override
	public void trace(String msg) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#trace(java.lang.String, java.lang.Object)
	 */
	@Override
	public void trace(String msg, Object object) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#trace(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void trace(String msg, Object object1, Object object2) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#trace(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void trace(String msg, Object[] objectArray) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#trace(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void trace(String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#warn(java.lang.String)
	 */
	@Override
	public void warn(String msg) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#warn(java.lang.String, java.lang.Object)
	 */
	@Override
	public void warn(String msg, Object object) {
		System.out.println(object.getClass().getName()+": "+msg);
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#warn(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void warn(String msg, Object[] objectArray) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#warn(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void warn(String msg, Object object1, Object object2) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.log.Logger#warn(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void warn(String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
