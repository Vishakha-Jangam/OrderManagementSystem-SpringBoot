package com.OMS.service;

import com.OMS.dto.OrdersDto;

public interface OrderService {

	public OrdersDto placeOrder(OrdersDto ordersDto, long custId);
	
	
}
