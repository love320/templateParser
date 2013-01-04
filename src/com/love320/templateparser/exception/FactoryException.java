 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.exception;

/** 
 * @ClassName: FactoryException 
 * @Description: TODO
 * @author love320.com
 * @date 2012-8-5 下午04:42:08 
 *  
 */
public class FactoryException extends AbstractException {
	
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	
	public FactoryException(){
		super(ErrorCodes.ERROR_CODE_10002);
	}
	
	public FactoryException(String msg){
		super(ErrorCodes.ERROR_CODE_10002,msg);
	}
	
	public FactoryException(Object[] arguments){
		super(ErrorCodes.ERROR_CODE_10002,arguments);
	}

	@Override
	protected String ModuleMethod() {
		return ErrorCodes.MODULE_CODE_1;
	}

}
