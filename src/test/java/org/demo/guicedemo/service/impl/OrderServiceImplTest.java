package org.demo.guicedemo.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.demo.guicedemo.service.OrderService;
import org.demo.guicedemo.service.PriceService;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Provider;
import com.google.inject.name.Named;

public class OrderServiceImplTest {
	@Inject
	private OrderService orderService;
	@Inject 
	private PriceService priceService;
	
	@Inject
	@Named("supportedCurrencies")
	private Provider<List<String>> supportedCurrenciesProvider;
	
	@Before 
	public void setUp() {
		// 没有这一行，orderService会是null
		Guice.createInjector(new ServerModule()/*,
				new AbstractModule() {
					
					@Override
					protected void configure() {
						// 连接绑定
						bind(PriceServiceImpl.class).toInstance(new PriceServiceImpl() {
							@Override
							public long getPrice(long orderId) {
								return 567L;
							}
						});
					}
				}*/).injectMembers(this);
	}
	
	@Test
	public void testSendToPayment() {
		orderService.sendToPayment(789L);
	}

	@Test
	public void testSupportedCurrencies() {
		throw new RuntimeException(priceService.getSupportedCurrencies().toString());
	}
}
