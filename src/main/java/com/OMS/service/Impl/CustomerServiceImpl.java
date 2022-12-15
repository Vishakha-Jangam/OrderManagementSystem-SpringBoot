package com.OMS.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.OMS.dto.CustomerDto;
import com.OMS.entity.Customer;
import com.OMS.repository.CustomerRepository;
import com.OMS.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
    
	private ModelMapper mapper;
	private CustomerRepository custRepo;
	
	
	
	public CustomerServiceImpl(ModelMapper mapper, CustomerRepository custRepo) {
		super();
		this.mapper = mapper;
		this.custRepo = custRepo;
	}



	@Override
	public CustomerDto registerCustomer(CustomerDto custdto) {
		
		Customer customer = mapToEntity(custdto);
		Customer newCust=custRepo.save(customer);
		CustomerDto cust =mapToDto(newCust);
		return cust;
	}
   
	
	
	
	private Customer mapToEntity(CustomerDto custdto) {
		Customer customer = mapper.map(custdto, Customer.class);
		return customer;
	}
	
	private CustomerDto mapToDto(Customer customer) {
		CustomerDto custDto = mapper.map(customer, CustomerDto.class);
		return custDto;
	}
	
}
