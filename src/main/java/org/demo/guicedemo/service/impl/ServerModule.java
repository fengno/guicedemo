package org.demo.guicedemo.service.impl;

import java.util.List;

import org.demo.guicedemo.service.OrderService;
import org.demo.guicedemo.service.PaymentService;
import org.demo.guicedemo.service.PriceService;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class ServerModule extends AbstractModule {

	@Override
	protected void configure() {
		// 类名绑定
		bind(OrderService.class).to(OrderServiceImpl.class);
		// 实例绑定
		bind(PaymentService.class).toInstance(new PaymentServiceImpl());
		// 在ut中使用连接绑定
		bind(PriceService.class).to(PriceServiceImpl.class);
		
	}
	
	@Provides @SessionId Long generateSessionId() {
		return System.currentTimeMillis();
	}

	@Provides List<String> getSupportedCurrencies(PriceService priceService) {
		return priceService.getSupportedCurrencies();
	}
}
