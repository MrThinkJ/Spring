package com.shoppingcart.service;

import com.shoppingcart.entity.OrderDetails;
import com.shoppingcart.entity.Orders;
import com.shoppingcart.repository.OrderDetailsRepository;
import com.shoppingcart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    public List<Orders> findAll(){
        return orderRepository.findAll();
    }

    public Orders findOrderById(int id){
        Orders orders = orderRepository.findById(id);
        return orders;
    }

    public Page<OrderDetails> findOrderDetailsByOrderId(Integer orderId, int size, int page){
        Pageable pageable = PageRequest.of(page, size);
        Page<OrderDetails> orderDetailsPage = orderDetailsRepository.findAllByOrders(orderRepository.findById(Integer.parseInt(String.valueOf(orderId))), pageable);
        return orderDetailsPage;
    }

//    public Page<OrderDetails> findOrderDetailsByQuantity(int quantity, int size, int page){
//        Pageable pageable = PageRequest.of(page, size);
//        Page<OrderDetails> orderDetailsPage = orderDetailsRepository.findByQuantity(quantity, pageable);
//        return orderDetailsPage;
//    }
}
