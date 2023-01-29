package controller;

import entity.OrderDetails;
import entity.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.OrderService;

import java.util.List;

@Controller
public class OrderController {
    @GetMapping(path = "/order")
    public String showOrder(Model model){
        List<Orders> ordersList = OrderService.findAll();
        model.addAttribute("ordersList", ordersList);
        return "order";
    }

    @GetMapping(path = "/orderdetails/{id}")
    public String showOrderDetails(@PathVariable int id,
                                   Model model){
        List<OrderDetails> orderDetailsList = OrderService.findOrderDetailsByOrderId(id);
        model.addAttribute("orderDetailsList", orderDetailsList);
        return "orderdetails";
    }
}
