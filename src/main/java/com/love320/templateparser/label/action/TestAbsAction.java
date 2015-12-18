/**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.label.action;

import java.util.Map;

import com.love320.templateparser.label.AbstractLabelAction;
import com.love320.templateparser.user.bean.SystemMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: TestAbsAction
 * @Description: TODO
 * @author love320.com
 * @date 2012-6-20 下午10:05:13
 * 
 */
public class TestAbsAction extends AbstractLabelAction {

    private final static Logger logger = LoggerFactory.getLogger(TestAbsAction.class);

	@Override
	public Map exec(Map renderMap, Map systemMap) {
        logger.debug(">>通过>"+renderMap);
		return renderMap;
	}

}
