package com.love320.templateparser.util;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {
	
	/**
	 * 专用 处理特殊字符串转Map
	 * @param str
	 * @return
	 */
	public static Map templateToMap(String str){
		//include name=Label.txt
		Map map = new HashMap<String,Object>();
		String[] ss = str.split(" ");
		for(String sing : ss){
			String[] kv = sing.split("=");
			if(kv.length == 2) map.put(kv[0], kv[1]);
		}
		return map;
	}

}
