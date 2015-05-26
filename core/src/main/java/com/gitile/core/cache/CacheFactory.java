package com.gitile.core.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;

/**
 * 缓存对象工厂方法
 */
public class CacheFactory {

    private CacheFactory() {}

    @SuppressWarnings("unchecked")
	public static <T> T get(Class<T> obj) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj);
        //初始化日志
        Logger logger = LoggerFactory.getLogger(obj);
        enhancer.setCallback(new CacheInterceptor(logger));
        return (T) enhancer.create();
    }
}
