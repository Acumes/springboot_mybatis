package com.htf.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.htf.service.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 缓存实现类
 * Created by PC-FENG on 2017/8/25.
 */
@Component
public class GuavaCacheService implements CacheService {
    private static final Logger logger = LoggerFactory.getLogger(GuavaCacheService.class);

    Cache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.DAYS).build();

    @Override
    public String setValue(String key, String value) {
        cache.put(key, value);
        return "";
    }

    @Override
    public String getValue(String key) {
        String value = cache.getIfPresent(key);
        if (value == null) {
            return "";
        } else {
            return value;
        }
    }

    @Override
    public void remove(Object key) {
        cache.invalidate(key);
    }
}
