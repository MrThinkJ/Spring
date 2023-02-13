package com.controller;

import com.entity.Orders;
import com.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@ComponentScan(basePackages = "service")
public class OrderController {
    @Autowired
    EntityService service;
    @GetMapping("/")
    public String getALlOrders(Model model){
        List<Orders> ordersList = service.findAllOrder();
        model.addAttribute("ordersList", ordersList);
        return "order";
    }

    @GetMapping("/search")
    public String search(@RequestParam (name = "searchInput") String searchInput,
                         Model model){
        List<Orders> ordersList = service.search(searchInput);
        model.addAttribute("ordersList", ordersList);
        return "order";
    }
}
