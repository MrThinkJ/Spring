package com.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
    @GetMapping("/access-denied")
    public String getAccessDenied(){
        return "role-error";
    }
}
