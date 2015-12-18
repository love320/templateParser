package com.love320.templateparser.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 文件读取工具
 * @author Administrator
 *
 */
public class FileUtil {

    private final static Logger logger = LoggerFactory.getLogger(FileUtil.class);

	public static InputStream getJar(String fileName) {
		InputStream is = AppPath.class.getResourceAsStream("/"+fileName);  
		return is;
	}
	
	public static InputStream get(String path) {
		File file = new File(AppPath.path()+path);  
        FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			return fis;
		} catch (FileNotFoundException e) {
            logger.error("FileNotFoundException", e);
		}
		return null;
	}

}
