 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.label.action;

import java.util.Map;

import com.love320.templateparser.label.LabelAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 /**
 * @ClassName: TestAction 
 * @Description: TODO
 * @author love320.com
 * @date 2012-5-8 下午09:43:50 
 *  
 */
public class TestAction implements LabelAction {

     private final static Logger logger = LoggerFactory.getLogger(TestAction.class);

	/* (non-Javadoc)
	 * @see com.love320.templateparser.label.LabelAction#action(java.util.Map)
	 */
	@Override
	public Map<String, Object> action(Map<String, Object> data) {
		//logger.debug("处理 成功"+data.get("system"));
		return data;
	}

	@Override
	public String template(String tem, Map<String, Object> data) {
		return tem;
	}

}
