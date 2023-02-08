package com.shoppingcart.controller;

import com.shoppingcart.entity.OrderDetails;
import com.shoppingcart.entity.Product;
import com.shoppingcart.service.OrderService;
import com.shoppingcart.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String productList(Model model){
        List<Product> productList = productService.productList();
        model.addAttribute("productList", productList);
        return "index";
    }
}
