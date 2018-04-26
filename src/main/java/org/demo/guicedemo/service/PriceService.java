package org.demo.guicedemo.service;

import java.util.Set;

public interface PriceService {

	long getPrice(long orderId);

	Set<String> getSupportedCurrencies();

}
