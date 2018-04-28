package org.demo.guicedemo.service.impl;

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

// mock
class PriceServiceMock extends PriceServiceImpl {

	@Inject
	public PriceServiceMock(Set<String> supportedCurrencies) {
		super(supportedCurrencies);
	}

	@Override
	public long getPrice(long orderId) {
		return 5678L;
	}
}

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
		Guice.createInjector(
			Modules.override(new ServerModule()) // 之前ServerModule中已经给PriceService绑定到了PriceServiceImpl，这里需Module覆盖
			.with(new AbstractModule() {
				@Override
				protected void configure() {
					bind(PriceService.class).to(PriceServiceMock.class);
				}
			})
		).injectMembers(this);
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
