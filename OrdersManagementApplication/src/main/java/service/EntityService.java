package service;

import configuration.JPAConfig;
import entity.OrderDetails;
import entity.Orders;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import repository.OrderDetailsRepository;
import repository.OrdersRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class EntityService {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static OrdersRepository ordersRepository = (OrdersRepository) context.getBean("ordersRepository");
    static OrderDetailsRepository orderDetailsRepository = (OrderDetailsRepository) context.getBean("orderDetailsRepository");
    public static Orders enterNewOrder(){
        Scanner sc = new Scanner(System.in);
        Orders orders = new Orders();
        System.out.println("Enter customer name: ");
        orders.setCustomerName(sc.nextLine());
        System.out.println("Enter customer address: ");
        orders.setCustomerAddress(sc.nextLine());
        orders.setOrderDate(LocalDate.now());
        ordersRepository.save(orders);
        return orders;
    }

    public static OrderDetails enterNewOrderDetails(){
        Scanner sc = new Scanner(System.in);
        OrderDetails orderDetails = new OrderDetails();
        System.out.println("Enter product name: ");
        orderDetails.setProductName(sc.nextLine());
        System.out.println("Enter unit price: ");
        orderDetails.setUnitPrice(sc.nextInt());
        System.out.println("Enter quantity: ");
        orderDetails.setQuantity(sc.nextInt());
        return orderDetails;
    }
    public static void createNewOrder(){
        ordersRepository.save(enterNewOrder());
    }
    public static void createNewOrderWithOrderDetails(){
        Orders orders = enterNewOrder();
        ordersRepository.save(orders);

        OrderDetails orderDetails = enterNewOrderDetails();
        orderDetails.setOrderId(orders);
        orderDetailsRepository.save(orderDetails);
    }

    public static void createNewOrderDetailsForOrder(){
        Scanner sc = new Scanner(System.in);
        OrderDetails orderDetails = enterNewOrderDetails();
        System.out.println("Enter orders id that you want to add this details for: ");
        Orders orders = ordersRepository.findById(sc.nextInt()).get();
        orderDetails.setOrderId(orders);
        orderDetailsRepository.save(orderDetails);
    }

    public static void listAllOrderAndOrderDetail(){
        List<Orders> ordersList = ordersRepository.findAll();
        for (Orders order : ordersList){
            System.out.println(order.toString());
            System.out.println("Order detail have order id: "+order.getId());
            List<OrderDetails> orderDetailsList = orderDetailsRepository.findByOrderId(order.getId());
            for (OrderDetails orderDetails : orderDetailsList)
                System.out.println(orderDetails.toString());;
        }
    }

    public static void getOrderAndOrderDetailsByOrderId(int orderId){
        Optional<Orders> orders = ordersRepository.findById(orderId);
        System.out.println( orders.get().toString());;
        List<OrderDetails> orderDetailsList = orderDetailsRepository.findByOrderId(orders.get().getId());
        for (OrderDetails orderDetails : orderDetailsList)
            System.out.println(orderDetails.toString());;
    }

    public static void listAllOrdersInCurrentMonth(){
        List<Orders> ordersList = ordersRepository.findAllInCurrentMonth();
        for (Orders orders : ordersList)
            System.out.println(orders.toString());;
    }

    public static void listAllOrderTotalAmout1000(){
        List<Orders> ordersList = ordersRepository.findAllTotalAmount1000();
        for (Orders orders : ordersList)
            System.out.println(orders.toString());;
    }

    public static void listAllOrderByProductName(){
        List<Orders> ordersList = ordersRepository.findByProductName();
        for (Orders orders : ordersList)
            System.out.println(orders.toString());;
    }

    public static void runApplication(){
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int choose;
        do{
            System.out.println("1. Create new order with order detail");
            System.out.println("2. Create new order");
            System.out.println("3. Create new order detail for order");
            switch (choose = sc.nextInt()){
                case 1:
                    createNewOrderWithOrderDetails();
                    break;
                case 2:
                    createNewOrder();
                    break;
                case 3:
                    createNewOrderDetailsForOrder();
                    break;
                case 4:
                    exit = true;
                    break;
            }
        } while (!exit);
    }
}
