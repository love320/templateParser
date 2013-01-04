 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.factory.impl;

import com.love320.templateparser.factory.LabelBeanFactory;
import com.love320.templateparser.factory.entity.LabelBean;
import com.love320.templateparser.label.LabelBeanDao;

/** 
 * @ClassName: LabelBeanFactoryImpl 
 * @Description: TODO
 * @author love320.com
 * @date 2012-5-6 下午08:33:41 
 *  生产labelBean工厂
 */
public class LabelBeanFactoryImpl implements LabelBeanFactory {

	private LabelBeanDao labelBeanDao;//labelBean操作对象
	
	public void setLabelBeanDao(LabelBeanDao labelBeanDao) {
		this.labelBeanDao = labelBeanDao;
	}

	/* (non-Javadoc)
	 * @see com.love320.templateparser.factory.LabelBeanFactory#get(java.lang.String)
	 */
	@Override
	public LabelBean get(String labelName) {
		return labelBeanDao.get(labelName);//获取对象
	}
}
