package com.htf.service;

/**
 * Created by PC-FENG on 2017/8/25.
 */
public interface CacheService {
    /* 设置简单字符串值
	 * @param key
	 * @param value
	 * @return
             */
    //public String setValue(String key, String value,int expired);
    String setValue(String key, String value);

    /**
     * 获取简单字符串值
     * @param key
     * @return
     */
    String getValue(String key);

    /**
     * 设置简单字符串值
     * @param key
     * @param value
     * @param timeout 分钟
     */
//	public void setValueForMinutes(Object key,Object value,int timeout);

    /** 获取简单字符串值
     * @param key
     * @return
     */
//	public Object getValue(Object key);
    /**
     * 移除
     * @param key
     */
    void remove(Object key);
}
