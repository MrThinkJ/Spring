package com.shoppingcart.controller;

import com.shoppingcart.entity.OrderDetails;
import com.shoppingcart.entity.Orders;
import com.shoppingcart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping(path = "/order")
    public String showOrder(Model model){
        List<Orders> ordersList = orderService.findAll();
        model.addAttribute("ordersList", ordersList);
        return "order";
    }

    @GetMapping(path = "/orderdetails/{id}")
    public String showOrderDetails(@PathVariable int id,
                                   @RequestParam(value = "page", required=false) Integer page,
                                   Model model){
        if (page == null)
            page = 0;
        if (page>=1)
            page-=1;
        int size = 10;
        Page<OrderDetails> orderDetailsPage = orderService.findOrderDetailsByOrderId(id, size, page);
        model.addAttribute("orderId", id);
        model.addAttribute("orderDetailsPage", orderDetailsPage);
        return "orderdetails";
    }
}
