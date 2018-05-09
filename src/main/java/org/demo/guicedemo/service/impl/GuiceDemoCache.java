package org.demo.guicedemo.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.common.cache.AbstractCache;

public class GuiceDemoCache extends AbstractCache<String, String> {
//	private final Map<String, String> keyValues = new HashMap<>();
//	如果是Singleton范围，考虑线程安全，建议用ConcurrentHashMap
	private final Map<String, String> keyValues = new ConcurrentHashMap<>();

	@Override
	public String getIfPresent(Object key) {
		return keyValues.get(key);
	}

	@Override
	public void put(String key, String value) {
		keyValues.put(key, value);
	}
}
