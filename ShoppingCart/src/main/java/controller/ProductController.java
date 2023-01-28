package controller;

import configuration.JPAConfig;
import entity.Cart;
import entity.Orders;
import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.annotation.Resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.ProductRepository;
import service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String productList(Model model){
        List<Product> productList = ProductService.productList();
        model.addAttribute("productList", productList);
        return "index";
    }
}
