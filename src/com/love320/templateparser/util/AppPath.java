 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.util;

import com.love320.templateparser.factory.AppFactory;

/** 
 * @ClassName: AppPath 
 * @Description: TODO
 * @author love320.com
 * @date 2012-6-16 下午07:36:33 
 *  应用运行的路径
 */
public class AppPath {
	public static String PATH = AppPath.class.getResource("/").toString();
}