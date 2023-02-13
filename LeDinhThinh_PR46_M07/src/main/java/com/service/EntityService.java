package com.service;

import com.entity.OrderDetails;
import com.entity.Orders;
import com.repository.OrderDetailsRepository;
import com.repository.OrdersRepository;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@ComponentScan(basePackages = "repository")
public class EntityService {
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    @Autowired
    ProductRepository productRepository;

    public List<Orders> findAllOrder(){
        return ordersRepository.findAll();
    }

    public List<OrderDetails> findOrderDetailsById(int orderId){
        return orderDetailsRepository.findByOrdersId(orderId);
    }

    public List<Orders> search(String searchInput){
        LocalDate orderDate;
        try {
            orderDate = LocalDate.parse(searchInput);
        }
        catch (Exception e){
            orderDate = LocalDate.parse("2002-02-02");
        }
        List<Orders> ordersList = ordersRepository.findByCustomerNameContainingOrOrderDateIsBetween(searchInput, orderDate, orderDate);
        try{
            if (ordersList.get(0) != null){
                return ordersList;
            }
        } catch (Exception e){
            List<Integer> integers = ordersRepository.findByOrderId(searchInput);
            for (Integer integer : integers){
                System.out.println(integer);
                ordersList.add(ordersRepository.findById(integer.intValue()));
            }
            return ordersList;
        }
        return ordersList;
    }
}
