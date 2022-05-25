package com.ordermgmt.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

@RestController
@RequestMapping("/api")
@Validated
public class OrdermgmtController {

	@Autowired
	OrderService orderservice;
	
	@GetMapping("/all/orders")
	Iterable<Order> getallOrders()
	{
		return orderservice.getallorders();
	}
	
	@GetMapping("/user/orders/{userid}")
	List<Order> getOrderbyId( @PathVariable int userid)
	{
		return orderservice.getOrdersbyUserId(userid);
	}
	
	@PostMapping("/order/{id}")
	String placeOrder(@PathVariable int id, @RequestBody Order order)
	{
		order.setUser(new User(id, "","",""));
		orderservice.addOrder(order);
		return "A order is successfully placed.";
	}
	
	@PutMapping("/order/{orderid}")
	String updateOrder(@NotNull @PathVariable int orderid, @RequestBody Order order)
	{
		orderservice.updateOrder(orderid,order);
		return "Order updated successfully";
	}
	@DeleteMapping("/order/{orderid}")
	String deleteOrder(@PathVariable int orderid)
	{
		orderservice.deleteOrder(orderid);
		return "Order deleted successfully";
	}
}
