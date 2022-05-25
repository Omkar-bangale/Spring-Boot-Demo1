package com.ordermgmt.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;
	
	//get all orders
	Iterable<Order> getallorders()
	{
		return repo.findAll();
	}
	//get orders placed by perticular user
	List<Order> getOrdersbyUserId(int id)
	{
		if(repo.findByUserId(id).isEmpty())
			throw new OrdernotFoundException();
		return repo.findByUserId(id);
	}
	
	//create a new order
	void addOrder(Order order)
	{
		 repo.save(order);
	}
	
	//Update the order
	void updateOrder(int orderid, Order order)
	{
		
		if(repo.findById(orderid).isEmpty())
				{
					throw new OrdernotFoundException();
				}
		Order order1=repo.findById(orderid).get();
		order1.setOrdername(order.getOrdername());
		order1.setBrand(order.getBrand());
		order1.setPrice(order.getPrice());
		repo.save(order1);	
	}
	
	//delete the order
	void deleteOrder(int orderid)
	{
		if(repo.findById(orderid).isEmpty())
			throw new OrdernotFoundException();
		repo.deleteById(orderid);
		
	}
}
