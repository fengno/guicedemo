package org.demo.guicedemo.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.google.common.cache.AbstractCache;

public class GuiceDemoCache extends AbstractCache<String, String> {
	private final Map<String, String> keyValues = new HashMap<>();

	@Override
	public String getIfPresent(Object key) {
		return keyValues.get(key);
	}

	@Override
	public void put(String key, String value) {
		keyValues.put(key, value);
	}
}
