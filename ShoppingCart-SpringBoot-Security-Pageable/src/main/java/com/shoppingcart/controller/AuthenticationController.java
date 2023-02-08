package com.shoppingcart.controller;

import com.shoppingcart.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("error", "Đăng nhập không thành công");
        return "login";
    }
    @PostMapping("/process-login")
    public String authLogin(){
        return "redirect:/";
    }
}
