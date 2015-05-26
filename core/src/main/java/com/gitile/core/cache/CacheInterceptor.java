package com.gitile.core.cache;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import com.gitile.core.cache.annotation.ClearCache;
import com.gitile.core.cache.annotation.UseCache;

/**
 * 缓存代理类
 */
public class CacheInterceptor implements MethodInterceptor {
	
    private Logger logger;

    public CacheInterceptor(Logger logger) {
        this.logger = logger;
    }

    //根据参数生成唯一id
    public String makeString(Object[] obj) {
        if (obj.length == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < obj.length; i++) {
            sb.append(obj[i]);
            sb.append(".");
        }
        return sb.toString();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Annotation[] annotations = method.getAnnotations();
        Object result = null;
        if (annotations.length > 0)
            for (int i = 0; i < annotations.length; i++) {
                if (annotations[i].annotationType() == UseCache.class) {
                    if (method.getReturnType() == Void.TYPE)
                        return methodProxy.invokeSuper(o, objects);
                    String cacheName = ((UseCache) annotations[i]).cacheName();
                    String cacheKey = makeString(objects);
                    Object getCache = CacheKit.get(cacheName, cacheKey);
                    if (getCache == null) {
                        logger.debug("create cache:" + cacheName);
                        result = methodProxy.invokeSuper(o, objects);
                        CacheKit.put(cacheName, cacheKey, result);
                    } else {
                        logger.debug("use cache:" + cacheName);
                        return getCache;
                    }
                } else if (annotations[i].annotationType() == ClearCache.class) {
                    String[] cacheName = ((ClearCache) annotations[i]).cacheName();
                    for (int j = 0; j < cacheName.length; j++) {
                        logger.debug("clear cache:" + cacheName[j]);
                        CacheKit.removeAll(cacheName[j]);
                    }
                    result = methodProxy.invokeSuper(o, objects);
                }
            }
        else
            result = methodProxy.invokeSuper(o, objects);

        return result;
    }

}
