package com.love320.templateparser.util;

import com.love320.templateparser.factory.AppFactory;
import com.love320.templateparser.factory.Factory;
import com.love320.templateparser.factory.impl.FactoryServiceSpringImpl;
import com.love320.templateparser.io.FileToString;
import com.love320.templateparser.templateprocess.TemplateProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * Created by zhangdi on 15-12-18.
 */
public class AppUtil {

    private final static Logger logger = LoggerFactory.getLogger(AppUtil.class);

    public static TemplateProcess newInstance(){
        return newInstance(null,null);
    }

    public static TemplateProcess newInstance(ApplicationContext ac){
        return newInstance(ac,null);
    }

    public static TemplateProcess newInstance(ApplicationContext ac,FileToString fts){
        //启动解析功能
        logger.info("Init ..." + ac);
        AppFactory appfactory = AppFactory.getAppFactory();
        Factory factory = appfactory.getFactory();
        FactoryServiceSpringImpl fss = (FactoryServiceSpringImpl)factory.getbean("factoryService");
        if(ac != null) fss.setApplicationContext(ac);//注入spring生产对象
        TemplateProcess templateProcess = (TemplateProcess)fss.getbean("templateProcess");

        //变更文件读取文件功能为本系统的FileCmsService
        if(fts != null) ReflectionUtils.invoke("setFileToString",templateProcess,fts);
        return templateProcess;
    }

}
