package com.gitile.core.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheKit {
	
    private static CacheManager cacheManager;
    private static final Logger log = LoggerFactory.getLogger(CacheKit.class);

    private static Cache getOrAddCache(String cacheName) {

        CacheManager cacheManager = getManager();
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            synchronized (cacheManager) {
                cache = cacheManager.getCache(cacheName);
                if (cache == null) {
                    log.debug("Could not find cache config [" + cacheName + "], using default.");
                    cacheManager.addCacheIfAbsent(cacheName);
                    cache = cacheManager.getCache(cacheName);
                    log.debug("Cache [" + cacheName + "] started.");
                }
            }
        }
        return cache;
    }


    private static CacheManager getManager() {
        if (cacheManager == null) {
            cacheManager = CacheManager.create();
        }
        return cacheManager;
    }


    public static void put(String cacheName, Object key, Object value) {
        getOrAddCache(cacheName).put(new Element(key, value));
    }

    public static Object get(String cacheName, Object key) {
        Element element = getOrAddCache(cacheName).get(key);
        return element != null ? element.getObjectValue() : null;
    }


    public static void remove(String cacheName, Object key) {
        getOrAddCache(cacheName).remove(key);
    }

    public static void removeAll(String cacheName) {
        getOrAddCache(cacheName).removeAll();
    }

}
