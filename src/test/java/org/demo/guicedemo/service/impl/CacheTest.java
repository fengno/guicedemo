package org.demo.guicedemo.service.impl;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;

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
		paymentService.putCache("testKey", "testValue with in");
		String cachedValue = priceService.getCachedValue("testKey");
		// singleton scope下，paymentService下设置的cache内容，在priceService中是可以取到的
		assertEquals("testValue with in", cachedValue);
	}
}
