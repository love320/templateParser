 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.label.synthesis.impl;

import java.io.IOException;
import java.io.StringWriter;

import com.love320.templateparser.label.Synthesis;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 /**
 * @ClassName: SynthesisFreeMarker 
 * @Description: TODO
 * @author love320.com
 * @date 2012-5-10 下午10:58:45 
 *  
 */
public class SynthesisFreeMarker implements Synthesis {

    private final static Logger logger = LoggerFactory.getLogger(SynthesisFreeMarker.class);

	/* (non-Javadoc)
	 * @see com.love320.templateparser.templateprocess.Synthesis#get(java.lang.Object, java.lang.String)
	 */
	@Override
	public String process(Object object, String templateSource) {
		
		Configuration cfg = new Configuration();    
        cfg.setTemplateLoader(new StringTemplateLoader(templateSource));    
        cfg.setDefaultEncoding("UTF-8");    
   
        Template template = null;    
		try {
			template = cfg.getTemplate("");
			 StringWriter writer = new StringWriter();    
		     template.process(object, writer);    
		     return writer.toString();
		} catch (IOException e) {
            logger.error("IOException",e);
		} catch (TemplateException e) {
            logger.error("TemplateException",e);
		}
		return null;
	}

}
