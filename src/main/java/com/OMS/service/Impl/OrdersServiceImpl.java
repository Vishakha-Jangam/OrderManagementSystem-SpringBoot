package com.OMS.service.Impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OMS.dto.OrdersDto;
import com.OMS.entity.Customer;
import com.OMS.entity.Orders;
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
		Optional<Customer> opt = custRepo.findById(custId);
		
		if(opt.isPresent()) {
			
			List<Orders> olist = opt.get().getOrders();
			
			if(olist.size()==10) {
				opt.get().setCategory("Gold");
			}else if (olist.size()==20) {
				opt.get().setCategory("platinum");
			}
			
			Orders newOrders = mapToentity(ordersDto);
			ordersRepo.save(newOrders);
			olist.add(newOrders);
			custRepo.save(opt.get());
			
		}
		return null;
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
