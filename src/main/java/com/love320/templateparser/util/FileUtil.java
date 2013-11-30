package com.love320.templateparser.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 文件读取工具
 * @author Administrator
 *
 */
public class FileUtil {

	public static InputStream getJar(String fileName) {
		InputStream is = AppPath.class.getResourceAsStream("/"+fileName);  
		return is;
	}
	
	public static InputStream get(String path) {
		File file = new File(AppPath.PATH+path);  
        FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			return fis;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
}
