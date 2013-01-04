 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.label;

import java.util.Map;

/** 
 * @ClassName: LabelProcess 
 * @Description: TODO
 * @author love320.com
 * @date 2012-5-6 下午07:46:55 
 *  标签解析核心
 */
public interface LabelProcess {
	public String get(String labelName,Map messageMap);
}
