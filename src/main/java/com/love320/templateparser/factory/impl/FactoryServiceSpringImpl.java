 /**
 * Copyright (c) 2010-2012 love320.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * Founder admin@love320.com
 */
package com.love320.templateparser.factory.impl;

import com.love320.templateparser.factory.AppFactory;
import com.love320.templateparser.factory.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

 /**
 * @ClassName: FactoryServiceImpl 
 * @Description: TODO
 * @author love320.com
 * @date 2012-5-6 下午09:44:42 
 *  
 */
public class FactoryServiceSpringImpl implements Factory {

     private final static Logger logger = LoggerFactory.getLogger(FactoryServiceSpringImpl.class);

     /* (non-Javadoc)
      * @see com.love320.templateparser.factory.Factory#getbean(java.lang.String)
      */
     private ApplicationContext applicationContext = null;

     private final static String tLabels[] ={"includeTempAction","templateProcess"};

     @Override
     public Object getbean(String beanName) {
         Object objBean = null;
         for(String sing:tLabels){
             if(sing.equals(beanName)) objBean = appfactory(beanName);
         }
         if(objBean == null && applicationContext != null) objBean= spring(beanName);
         if(objBean == null) objBean = appfactory(beanName);
         return objBean;
     }

     private Object appfactory(String beanName){
         AppFactory appfactory = AppFactory.getAppFactory();
         Factory factory = appfactory.getFactory();
         return factory.getbean(beanName);
     }

     private Object spring(String beanName){
         if(applicationContext != null){
             try{
                 return applicationContext.getBean(beanName);
             }catch (NoSuchBeanDefinitionException e){
                 logger.error("NoSuchBeanDefinitionException",e);
             }
         }
         return null;
     }



     public void setApplicationContext(ApplicationContext applicationContext) {
         this.applicationContext = applicationContext;
     }
 }
