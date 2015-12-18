 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.util;

import java.net.URL;

/** 
 * @ClassName: AppPath 
 * @Description: TODO
 * @author love320.com
 * @date 2012-6-16 下午07:36:33 
 *  应用运行的路径
 */
public class AppPath {

	private static URL URL = AppPath.class.getResource("/");
	
	public static String path(){
		return APPath();
	}
	
	//APP
	public static String APPath(){

		String url = URL.toString();
        String appPath = null;
        if(OSInfoUtil.getOSname() == EPlatform.Windows){
            String path = url.substring(6, url.length());
            appPath = path.replace('/','\\');
        }
        if(OSInfoUtil.getOSname() == EPlatform.Linux){
            String path = url.substring(5, url.length());
            appPath = path;
        }
        return appPath;
	}
	
	//WEB
	public static String WebPath(){
		return null;
	}
}
