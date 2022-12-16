package com.OMS.service;

import org.springframework.stereotype.Service;

import com.OMS.dto.OrdersDto;

@Service
public interface OrderService {

	public OrdersDto placeOrder(OrdersDto ordersDto, long custId);
	
	
}
