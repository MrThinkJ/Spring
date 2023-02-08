package com.shoppingcart.repository;

import com.shoppingcart.entity.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders, Integer> {
    List<Orders> findAll();
    Orders findById(int id);
}
