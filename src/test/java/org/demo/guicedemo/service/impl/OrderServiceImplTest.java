package org.demo.guicedemo.service.impl;

import javax.inject.Inject;

import org.demo.guicedemo.service.OrderService;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;

public class OrderServiceImplTest {
	@Inject
	private OrderService orderService;
	
	@Before 
	public void setUp() {
		// 没有这一行，orderService会是null
		Guice.createInjector(new ServerModule()).injectMembers(this);
	}
	
	@Test
	public void testSendToPayment() {
		orderService.sendToPayment(789L);
	}

}
