package com.love320.templateparser.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhangdi on 15-12-17.
 */
public class ReflectionUtils {

    private final static Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

    public static boolean invoke(String methodName,Object target,Object obj){
        for(Method method : target.getClass().getMethods()){
            if(method.getName().equals(methodName)){
                try {
                    method.invoke(target,obj);
                    return true;
                } catch (IllegalAccessException e) {
                    logger.error("IllegalAccessException", e);
                } catch (InvocationTargetException e) {
                    logger.error("InvocationTargetException",e);
                }
            }
        }
        return false;
    }
}
