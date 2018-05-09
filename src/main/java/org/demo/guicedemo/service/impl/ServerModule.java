package org.demo.guicedemo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.demo.guicedemo.service.OrderService;
import org.demo.guicedemo.service.PaymentService;
import org.demo.guicedemo.service.PriceService;

import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

public class ServerModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new ChinaModule());
		install(new GlobalModule());
		
		// 类名绑定
		bind(OrderService.class).to(OrderServiceImpl.class);
		
		bind(PaymentService.class).to(PaymentServiceImpl.class);
		// 在ut中使用连接绑定
		bind(PriceService.class).to(PriceServiceImpl.class);
		
		/*// 这种方式绑定后 sessionId的值不会变
		bind(Long.class).annotatedWith(SessionId.class).toInstance(System.currentTimeMillis());
		
		bind(Long.class).annotatedWith(Names.named("appId")).toInstance(345L);*/
		
		// 泛型绑定
		bind(new TypeLiteral<List<String>>() {}).annotatedWith(Names.named("supportedCurrencies")).toInstance(Arrays.asList("CNY", "EUR", "USD"));
		
		bind(new TypeLiteral<Cache<String, String>>(){}).to(GuiceDemoCache.class).in(Singleton.class);;
	}
	
	// 命名绑定 自定义注解实现
	@Provides @SessionId Long generateSessionId() {
		return System.currentTimeMillis();
	}

/*	// 命名绑定 字符串实现（关键是返回值类型和名字 即 @Named("") List<String>）
	@Provides @Named("supportedCurrencies") List<String> getSupportedCurrencies(PriceService priceService) {
		return priceService.getSupportedCurrencies();
	}*/
}
