package org.demo.guicedemo.service;

import java.util.List;

public interface PriceService {

	long getPrice(long orderId);

	List<String> getSupportedCurrencies();

}
