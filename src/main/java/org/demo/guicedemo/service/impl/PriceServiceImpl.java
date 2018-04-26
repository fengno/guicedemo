package org.demo.guicedemo.service.impl;

import java.util.Set;

import javax.inject.Inject;

import org.demo.guicedemo.service.PriceService;

public class PriceServiceImpl implements PriceService {
	private final Set<String> supportedCurrencies;
	
	@Inject
	public PriceServiceImpl(Set<String> supportedCurrencies) {
		super();
		this.supportedCurrencies = supportedCurrencies;
	}

	@Override
	public long getPrice(long orderId) {
		throw new UnsupportedOperationException();
//		return 456L;
	}

	@Override
	public Set<String> getSupportedCurrencies() {
		return supportedCurrencies;
	}

}
