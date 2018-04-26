package org.demo.guicedemo.service.impl;

import javax.inject.Inject;

import org.demo.guicedemo.service.OrderService;
import org.demo.guicedemo.service.PaymentService;
import org.demo.guicedemo.service.PriceService;

public class OrderServiceImpl implements OrderService {

	// Dependencies
	private final PriceService priceService;
	private final PaymentService paymentService;
	private final SeesionManager sessionManager;
	
	// States
	private Long ordersPaid = 0L;
	
	@Inject
	public OrderServiceImpl(PriceService priceService,
			PaymentService paymentService,
			SeesionManager sessionManager) {
		super();
		this.priceService = priceService;
		this.paymentService = paymentService;
		this.sessionManager = sessionManager;
	}
	
	public void sendToPayment(long orderId) {
		long price = priceService.getPrice(orderId);
		paymentService.pay(orderId, price, sessionManager.getSessionId());
		ordersPaid = ordersPaid + 1;
		
		/*
		 * 通过异常的信息，确定单元测试真实执行了方法内部代码
		 */
		throw new RuntimeException(
				"Price=" + price
				+ ". SessionId=" + sessionManager.getSessionId()
				+ ". ordersPaid=" + ordersPaid);
	}
}
