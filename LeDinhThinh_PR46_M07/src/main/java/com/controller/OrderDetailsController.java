package com.controller;

import com.entity.OrderDetails;
import com.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@ComponentScan(basePackages = "service")
public class OrderDetailsController {
    @Autowired
    EntityService service;

    @GetMapping("/orderdetails/{id}")
    public String getOrderDetails(@PathVariable int id,
                                  Model model){
        List<OrderDetails> orderDetailsList = service.findOrderDetailsById(id);
        model.addAttribute("orderDetailsList", orderDetailsList);
        return "orderdetails";
    }
}
