package com.shopmilk.service;

import java.util.List;

import com.shopmilk.entities.Order;

public interface OrderService {

	Iterable<Order> findAll();
	
	List<Order> getNewOrder();
	
	List<Order> getCheckedOrder();

	Order findOne(int id);

	void save(Order order);

	void update(Order order);

}
