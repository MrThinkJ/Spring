package service;

import configuration.JPAConfig;
import entity.Cart;
import entity.OrderDetails;
import entity.Orders;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import repository.OrderDetailsRepository;
import repository.OrderRepository;
import repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class CartService {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static OrderRepository orderRepository = (OrderRepository) context.getBean("orderRepository");
    static OrderDetailsRepository orderDetailsRepository = (OrderDetailsRepository) context.getBean("orderDetailsRepository");
    public static void checkout(Cart cart, Orders order){
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

    public static int calTotalAmount(Cart cart){
        int totalAmount = 0;
        List<OrderDetails> orderDetailsList = cart.getOrder().getOrderDetailsList();
        for (OrderDetails orderDetails : orderDetailsList)
            totalAmount += orderDetails.getQuantity()*orderDetails.getProduct().getPrice();
        return totalAmount;
    }
}
