package com.shoppingcart.service;

import com.shoppingcart.entity.Cart;
import com.shoppingcart.entity.OrderDetails;
import com.shoppingcart.entity.Orders;
import com.shoppingcart.repository.OrderDetailsRepository;
import com.shoppingcart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CartService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    public void checkout(Cart cart, Orders order){
        Orders orders = cart.getOrder();
        String customerName = order.getCustomerName();
        String customerAddress = order.getCustomerAddress();
        orders.setCustomerName(customerName);
        orders.setCustomerAddress(customerAddress);
        orders.setOrderDate(LocalDate.now());
        List<OrderDetails> orderDetailsList = orders.getOrderDetailsList();
        orderRepository.save(orders);
        for (OrderDetails orderDetails : orderDetailsList)
            orderDetailsRepository.save(orderDetails);
    }

    public int calTotalAmount(Cart cart){
        int totalAmount = 0;
        List<OrderDetails> orderDetailsList = cart.getOrder().getOrderDetailsList();
        for (OrderDetails orderDetails : orderDetailsList)
            totalAmount += orderDetails.getQuantity()*orderDetails.getProduct().getPrice();
        return totalAmount;
    }
}
