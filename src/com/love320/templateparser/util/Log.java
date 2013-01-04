 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.util;

import com.love320.templateparser.factory.AppFactory;
import com.love320.templateparser.log.Logger;


/** 
 * @ClassName: Log 
 * @Description: TODO
 * @author love320.com
 * @date 2012-8-4 下午06:02:26 
 *  日志工具
 */
public class Log {
	
	public static Logger LOGGER = (Logger)AppFactory.getAppFactory().getFactory().getbean("logger");

}
