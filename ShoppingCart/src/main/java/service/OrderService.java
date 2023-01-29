package service;

import configuration.JPAConfig;
import entity.OrderDetails;
import entity.Orders;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import repository.OrderDetailsRepository;
import repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static OrderRepository orderRepository = (OrderRepository) context.getBean("orderRepository");
    static OrderDetailsRepository orderDetailsRepository = (OrderDetailsRepository) context.getBean("orderDetailsRepository");

    public static List<Orders> findAll(){
        return orderRepository.findAll();
    }

    public static Orders findOrderById(int id){
        Orders orders = orderRepository.findById(id);
        return orders;
    }

    public static List<OrderDetails> findOrderDetailsByOrderId(int orderId){
        List<OrderDetails> orderDetailsList = orderDetailsRepository.findByOrderId(orderId);
        return orderDetailsList;
    }
}
