<<<<<<< HEAD
package controller;

import entity.Cart;
import entity.OrderDetails;
import entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CartService;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@ComponentScan("entity")
public class CartController {
    @Autowired
    Cart cart;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    private String showCart(Model model) {
        List<OrderDetails> orderDetailsList = cart.getOrder().getOrderDetailsList();
        System.out.println(orderDetailsList.toString());
        model.addAttribute("orderDetailsList", orderDetailsList);
        model.addAttribute("totalAmount", CartService.calTotalAmount(cart));
        return "cart";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String addItem(@RequestParam(name = "id") int productId) {
        cart.addItem(productId);
        return "redirect:/";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    private String showItem() {
        System.out.println(cart.getOrder().getOrderDetailsList().toString());
        return "redirect:/";
    }

    @RequestMapping(value = "/remove", method = {RequestMethod.GET, RequestMethod.POST})
    private String removeItem(@RequestParam(name = "product-id") int productId) {
        cart.removeItem(productId);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    private String processCheckout(@RequestParam(name = "customerName") String customerName,
                                   @RequestParam(name = "customerAddress") String customerAddress,
                                   HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        CartService.checkout(cart, customerName, customerAddress);
        cart.emptyCart();
        return "redirect:/";
    }

    @RequestMapping(value = "/increase", method = RequestMethod.POST)
    private String increaseProduct(@RequestParam(name = "product-id") int productId){
        cart.increase(productId);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/decrease", method = RequestMethod.POST)
    private String decreaseProduct(@RequestParam(name = "product-id") int productId){
        cart.decrease(productId);
        return "redirect:/cart";
    }

}
=======
package controller;

import entity.Cart;
import entity.OrderDetails;
import entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CartService;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@ComponentScan("entity")
public class CartController {
    @Autowired
    Cart cart;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    private String showCart(Model model) {
        List<OrderDetails> orderDetailsList = cart.getOrder().getOrderDetailsList();
        System.out.println(orderDetailsList.toString());
        ;
        model.addAttribute("orderDetailsList", orderDetailsList);
        model.addAttribute("totalAmount", CartService.calTotalAmount(cart));
        return "cart";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String addItem(@RequestParam(name = "id") int productId) {
        cart.addItem(productId);
        return "redirect:/";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    private String showItem() {
        System.out.println(cart.getOrder().getOrderDetailsList().toString());
        return "redirect:/";
    }

    @RequestMapping(value = "/remove", method = {RequestMethod.GET, RequestMethod.POST})
    private String removeItem(@RequestParam(name = "product-id") int productId) {
        cart.removeItem(productId);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    private String processCheckout(@RequestParam(name = "customerName") String customerName,
                                   @RequestParam(name = "customerAddress") String customerAddress,
                                   HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        CartService.checkout(cart, customerName, customerAddress);
        cart.emptyCart();
        return "redirect:/";
    }

    @RequestMapping(value = "/increase", method = RequestMethod.POST)
    private String increaseProduct(@RequestParam(name = "product-id") int productId){
        cart.increase(productId);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/decrease", method = RequestMethod.POST)
    private String decreaseProduct(@RequestParam(name = "product-id") int productId){
        cart.decrease(productId);
        return "redirect:/cart";
    }

}
>>>>>>> b0da8640a166fc3ea30658d2af083bb238490599
