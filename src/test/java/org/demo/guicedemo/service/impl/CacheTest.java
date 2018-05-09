package org.demo.guicedemo.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.demo.guicedemo.service.OrderService;
import org.demo.guicedemo.service.PriceService;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.google.inject.util.Modules;

public class CacheTest {
	@Inject
	private PaymentServiceImpl paymentService;
	@Inject
	private PriceServiceImpl priceService;

	@Before
	public void setUp() {
		Guice.createInjector(new ServerModule()).injectMembers(this);
	}

	@Test
	public void testCache() {
		paymentService.putCache("testKey", "testValue");
		String cachedValue = priceService.getCachedValue("testKey");
		// 默认scope下，paymentService下设置的cache内容，在priceService中是取不到的
		assertNull(cachedValue);
	}
}
