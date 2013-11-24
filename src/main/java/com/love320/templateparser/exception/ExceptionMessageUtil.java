 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.exception;

import com.love320.templateparser.i18n.AbstractMessageUtil;
import com.love320.templateparser.i18n.MessageSource;
import com.love320.templateparser.i18n.impl.ExceptionMessageSource;

/** 
 * @ClassName: ExceptionMessageUtil 
 * @Description: TODO
 * @author love320.com
 * @date 2012-8-5 下午04:02:07 
 *  
 */
public class ExceptionMessageUtil extends AbstractMessageUtil {
	
	public static ExceptionMessageUtil E = new ExceptionMessageUtil();

	/* (non-Javadoc)
	 * @see com.love320.templateparser.i18n.AbstractMessageUtil#MessageSourceFactoryMethod()
	 */
	@Override
	protected MessageSource MessageSourceFactoryMethod() {
		return new ExceptionMessageSource();
	}

}
