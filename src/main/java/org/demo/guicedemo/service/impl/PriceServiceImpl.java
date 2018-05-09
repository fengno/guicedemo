package org.demo.guicedemo.service.impl;

import java.util.Set;

import javax.inject.Inject;

import org.demo.guicedemo.service.PriceService;

import com.google.common.cache.Cache;

public class PriceServiceImpl implements PriceService {
	private final Set<String> supportedCurrencies;
	private final Cache<String, String> cache;
	
	@Inject
	public PriceServiceImpl(Set<String> supportedCurrencies, Cache<String, String> cache) {
		super();
		this.supportedCurrencies = supportedCurrencies;
		this.cache = cache;
	}

	@Override
	public long getPrice(long orderId) {
		throw new UnsupportedOperationException();
//		return 456L;
	}

	@Override
	public Set<String> getSupportedCurrencies() {
		return supportedCurrencies;
	}

	String getCachedValue(String key) {
		return cache.getIfPresent(key);
	}
}
