package org.demo.guicedemo.service.impl;

import org.demo.guicedemo.service.OrderService;
import org.demo.guicedemo.service.PaymentService;
import org.demo.guicedemo.service.PriceService;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class ServerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(OrderService.class).to(OrderServiceImpl.class);
		bind(PriceService.class).to(PriceServiceImpl.class);
		bind(PaymentService.class).to(PaymentServiceImpl.class);
	}
	
	@Provides @SessionId Long generateSessionId() {
		return System.currentTimeMillis();
	}

}
