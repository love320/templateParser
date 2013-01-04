 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.log;

/** 
 * @ClassName: Log 
 * @Description: TODO
 * @author love320.com
 * @date 2012-8-4 下午06:44:39 
 *  
 *  日志接口，参考  org.slf4j.Logger
 */
public interface Logger {

	 final public String ROOT_LOGGER_NAME = "ROOT";

	  public String getName();

	  public boolean isTraceEnabled();

	  public void trace(String msg);

	  public void trace(String msg, Object object);

	  public void trace(String msg, Object object1, Object object2);

	  public void trace(String msg, Object[] objectArray);
	 
	  public void trace(String msg, Throwable t);

	  public boolean isDebugEnabled();
	  
	  public void debug(String msg);

	  public void debug(String msg, Object object);

	  public void debug(String msg, Object object1, Object object2);

	  public void debug(String msg, Object[] objectArray);

	  public void debug(String msg, Throwable t);

	  public boolean isInfoEnabled();

	  public void info(String msg);

	  public void info(String msg, Object object);

	  public void info(String msg, Object object1, Object object2);

	  public void info(String msg, Object[] objectArray);
	  
	  public void info(String msg, Throwable t);

	  public boolean isWarnEnabled();

	  public void warn(String msg);

	  public void warn(String msg, Object object);

	  public void warn(String msg, Object[] objectArray);
	  
	  public void warn(String msg, Object object1, Object object2);
	  
	  public void warn(String msg, Throwable t);

	  public boolean isErrorEnabled();
	  
	  public void error(String msg);

	  public void error(String msg, Object object);

	  public void error(String msg, Object object1, Object object2);

	  public void error(String msg, Object[] objectArray);
	  
	  public void error(String msg, Throwable t);

}
