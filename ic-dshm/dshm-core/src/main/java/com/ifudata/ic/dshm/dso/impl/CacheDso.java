package com.ifudata.ic.dshm.dso.impl;

import java.util.Map;


import com.ifudata.dvp.sdk.util.RedisUtil;
import com.ifudata.ic.dshm.dso.interfaces.IDso;
//import com.ifudata.ic.dshm.util.CacheFactoryUtil;
//import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;


//@Repository("cacheDso")
public class CacheDso implements IDso{
//	private ICacheClient  cacheClient=null;
//	private ICacheClient  cacheClient =  CacheFactoryUtil
//            .getCacheClient(CacheBLMapper.CACHE_BL_CAL_PARAM);
	public CacheDso() throws Exception{
//		cacheClient =  (ICacheClient) CacheFactoryUtil
//                .getCacheClient(CacheBLMapper.CACHE_BL_CAL_PARAM);
	}
	@Override
	public void hset(String key, String field, String value) {
		RedisUtil.hset(key, field, value);
	}
	@Override
	public String hget(String key, String field) {
		return RedisUtil.hget(key, field);
	}
	@Override
	public Boolean hexists(String key, String field) {
		return RedisUtil.hexists(key, field);
	}
	@Override
	public Long hdel(String key, String[] field) {
		return RedisUtil.hdel(key, field);
	}
	@Override
	public Map<String, String> getMap(String key) {
		return RedisUtil.hgetAll(key);
	}
	@Override
	public boolean isExist(String key) {
		return RedisUtil.exists(key);
	}
	@Override
	public void addItem2ListTail(String key, String item) {
		
	}

	@Override
	public void addItem2ListHead(String key, String item) {
		
	}
	@Override
	public Long del(String key) {
		return RedisUtil.del(key);
		
	}
	@Override
	public void set(String key, String value) {
		RedisUtil.set(key, value);
	}
	@Override
	public String get(String key) {
		return RedisUtil.get(key);
	}
}
