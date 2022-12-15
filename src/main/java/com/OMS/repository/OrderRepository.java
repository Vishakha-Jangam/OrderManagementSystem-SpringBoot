package com.OMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OMS.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}
