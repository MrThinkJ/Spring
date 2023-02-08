package com.shoppingcart.entity;

import com.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private Orders order;
    @Autowired
    ProductService productService;

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Cart() {
        order = new Orders();
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        order.setOrderDetailsList(orderDetailsList);
    }

    public void addItem(int productId) {
        System.out.println(productId);
        List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
        if (isExist(productId))
            return;
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(1);
        orderDetails.setQuantity(1);
        orderDetails.setOrders(order);
        orderDetails.setProduct(productService.findById(productId));
        orderDetailsList.add(orderDetails);
        order.setOrderDetailsList(orderDetailsList);
    }

    public void removeItem(int productId) {
        List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
        orderDetailsList.removeIf(details -> details.getProduct().getId() == productId);
        order.setOrderDetailsList(orderDetailsList);
    }

    public void emptyCart() {
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        order.setOrderDetailsList(orderDetailsList);
    }

    public boolean isExist(int productId) {
        List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
        for (OrderDetails orderDetails : orderDetailsList) {
            if (orderDetails.getProduct().getId() == productId) {
                orderDetails.setQuantity(orderDetails.getQuantity() + 1);
                return true;
            }
        }
        return false;
    }

    public void increase(int productId) {
        List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
        for (OrderDetails orderDetails : orderDetailsList)
            if (orderDetails.getProduct().getId() == productId)
                orderDetails.setQuantity(orderDetails.getQuantity() + 1);
        order.setOrderDetailsList(orderDetailsList);
    }

    public void decrease(int productId) {
        OrderDetails temp = null;
        List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
        for (OrderDetails orderDetails : orderDetailsList) {
            if (orderDetails.getProduct().getId() != productId)
                continue;
            orderDetails.setQuantity(orderDetails.getQuantity() - 1);
            if (orderDetails.getQuantity() == 0)
                temp = orderDetails;
        }
        if (temp != null)
            removeItem(temp.getProduct().getId());
        order.setOrderDetailsList(orderDetailsList);
    }
}
