package com.OMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OMS.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
