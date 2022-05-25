package com.ordermgmt.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.sun.istack.NotNull;



@Validated
@Entity
@Table(name="ordertable")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	@NotNull
	@Column(name="itemname")
	private String ordername;
	private String brand;
	
	@Column(name="itemprice")
	@NotNull
	private double price;
	@ManyToOne  //many orders for a user
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Order(int orderid, String ordername, String brand, double price, int id) {
		super();
		this.orderid = orderid;
		this.ordername = ordername;
		this.brand = brand;
		this.price = price;
		this.user = new User(id, "","","");
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Order()
	{
		
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", ordername=" + ordername + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
	
	
	
}
