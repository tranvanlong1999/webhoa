package com.shopmilk.repository;

import org.springframework.data.repository.CrudRepository;

import com.shopmilk.entities.Order;

public interface OrderRepo extends CrudRepository<Order, Integer>  {

}
