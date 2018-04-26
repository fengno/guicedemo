package org.demo.guicedemo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.demo.guicedemo.service.PriceService;

public class PriceServiceImpl implements PriceService {

	@Override
	public long getPrice(long orderId) {
		throw new UnsupportedOperationException();
//		return 456L;
	}

	@Override
	public List<String> getSupportedCurrencies() {
		return Arrays.asList("CNY", "USD", "EUR");
	}

}
