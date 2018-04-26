package org.demo.guicedemo.service.impl;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class GlobalModule extends AbstractModule {

	@Override
	protected void configure() {
		// Adds EUR, USD support
		Multibinder<String> currencyBinder = Multibinder.newSetBinder(binder(), String.class);
		currencyBinder.addBinding().toInstance("EUR");
		currencyBinder.addBinding().toInstance("USD");
		
		// map
//		MapBinder.newMapBinder(binder, keyType, valueType)
	}

}
