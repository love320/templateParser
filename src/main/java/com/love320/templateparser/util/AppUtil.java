package com.love320.templateparser.util;

import com.love320.templateparser.factory.AppFactory;
import com.love320.templateparser.factory.Factory;
import com.love320.templateparser.factory.LabelBeanFactory;
import com.love320.templateparser.factory.impl.FactoryServiceSpringImpl;
import com.love320.templateparser.io.FileToString;
import com.love320.templateparser.label.LabelBeanDao;
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
        return newInstance(ac,fts,null);
    }

    public static TemplateProcess newInstance(ApplicationContext ac,FileToString fts,LabelBeanDao lbd){
        //启动解析功能
        logger.info("Init template process...");
        AppFactory appfactory = AppFactory.getAppFactory();
        Factory factory = appfactory.getFactory();
        FactoryServiceSpringImpl fss = (FactoryServiceSpringImpl)factory.getbean("factoryService");
        if(ac != null) fss.setApplicationContext(ac);//注入spring生产对象
        TemplateProcess templateProcess = (TemplateProcess)fss.getbean("templateProcess");

        //变更文件读取文件功能为外部系统功能
        if(fts != null) ReflectionUtils.invoke("setFileToString",templateProcess,fts);

        //变更标签管理器为外部系统功能
        if(lbd != null){
            LabelBeanFactory labelBeanFactory = (LabelBeanFactory)fss.getbean("labelBeanFactory");
            ReflectionUtils.invoke("setLabelBeanDao",labelBeanFactory,lbd);
        }
        return templateProcess;
    }

}
