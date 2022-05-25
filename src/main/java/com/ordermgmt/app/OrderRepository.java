package com.ordermgmt.app;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer>{

	List<Order> findByUserId(int id);
}
