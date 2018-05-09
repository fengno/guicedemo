package org.demo.guicedemo.service.impl;

import org.demo.guicedemo.service.PaymentService;

import com.google.common.cache.Cache;
import com.google.inject.Inject;

public class PaymentServiceImpl implements PaymentService {
	private final Cache<String, String> cache;
	
	@Inject
	public PaymentServiceImpl(Cache<String, String> cache) {
		super();
		this.cache = cache;
	}

	@Override
	public void pay(long orderId, long price, Long sessionId) {
	}

	void putCache(String key, String value) {
		cache.put(key, value);
	}
}
