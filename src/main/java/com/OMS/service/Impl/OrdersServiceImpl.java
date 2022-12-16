package com.OMS.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OMS.dto.OrdersDto;
import com.OMS.entity.Customer;
import com.OMS.entity.Orders;
import com.OMS.exception.CustomerException;
import com.OMS.repository.CustomerRepository;
import com.OMS.repository.OrderRepository;
import com.OMS.service.OrderService;

@Service
public class OrdersServiceImpl  implements OrderService{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private OrderRepository ordersRepo;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Override
	public OrdersDto placeOrder(OrdersDto ordersDto, long custId) {
		Orders order = mapToentity(ordersDto);
		Customer customer = custRepo.findById(custId)
				 .orElseThrow(()->new CustomerException("Customer Not register, please register first..."));
		 
		Set<Orders> orderSet= customer.getOrders();
		orderSet.add(order);

		Integer amount=0;
		for(Orders ord :orderSet) {
			amount =amount+ord.getTotalPrice();
		}
		
		if(orderSet.size()==10) {
			customer.setCategory("Gold");
			customer.setDiscountPrice(amount*10/100);
		}
		if (orderSet.size()==20) {
			customer.setCategory("platinum");
			customer.setDiscountPrice(amount*20/100);
		}
		
	
		order.setCustomer(customer);
		Orders newOrder= ordersRepo.save(order);
		custRepo.save(customer);
		return mapToDto(newOrder);
	
	}

	
	
	private Orders mapToentity(OrdersDto ordersDto) {
		Orders orders =mapper.map(ordersDto, Orders.class);
		return orders;
	}
	
	private OrdersDto mapToDto (Orders orders) {
		OrdersDto ordersDto =mapper.map(orders, OrdersDto.class);
		return ordersDto;
	}
}
