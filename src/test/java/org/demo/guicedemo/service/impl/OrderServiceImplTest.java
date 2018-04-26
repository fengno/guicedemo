package org.demo.guicedemo.service.impl;

import static org.junit.Assert.*;

import org.demo.guicedemo.service.OrderService;
import org.junit.Test;

import com.google.inject.Guice;

public class OrderServiceImplTest {

	@Test
	public void testSendToPayment() {
		OrderService orderService = Guice.createInjector(new ServiceModul()).getInstance(OrderService.class);
		orderService.sendToPayment(789L);
	}

}
