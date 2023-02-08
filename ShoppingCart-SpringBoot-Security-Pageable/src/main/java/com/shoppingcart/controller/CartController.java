package com.shoppingcart.controller;

import com.shoppingcart.entity.Cart;
import com.shoppingcart.entity.OrderDetails;
import com.shoppingcart.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.shoppingcart.service.CartService;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@ComponentScan("entity")
public class CartController {
    @Autowired
    Cart cart;
    @Autowired
    CartService cartService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    private String showCart(Model model) {
        List<OrderDetails> orderDetailsList = cart.getOrder().getOrderDetailsList();
        System.out.println(orderDetailsList.toString());
        model.addAttribute("orderDetailsList", orderDetailsList);
        model.addAttribute("totalAmount", cartService.calTotalAmount(cart));
        return "cart";
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    private String addItem(@RequestParam(name = "id") int productId) {
        cart.addItem(productId);
        return "redirect:/";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    private String showItem() {
        System.out.println(cart.getOrder().getOrderDetailsList().toString());
        return "redirect:/";
    }

    @RequestMapping(value = "/remove-product", method = {RequestMethod.GET, RequestMethod.POST})
    private String removeItem(@RequestParam(name = "product-id") int productId) {
        cart.removeItem(productId);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/checkout-product", method = RequestMethod.GET)
    private String showCheckoutForm(Model model){
        model.addAttribute("orders", new Orders());
        return "checkout-form";
    }

    @RequestMapping(value = "/process-checkout", method = RequestMethod.POST)
    private String processCheckout(@Valid @ModelAttribute("orders") Orders orders,
                                   BindingResult result) throws UnsupportedEncodingException {
        if (result.hasErrors())
            return "checkout-form";
        cartService.checkout(cart, orders);
        cart.emptyCart();
        return "redirect:/";
    }

    @RequestMapping(value = "/increase-product", method = RequestMethod.POST)
    private String increaseProduct(@RequestParam(name = "product-id") int productId){
        cart.increase(productId);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/decrease-product", method = RequestMethod.POST)
    private String decreaseProduct(@RequestParam(name = "product-id") int productId){
        cart.decrease(productId);
        return "redirect:/cart";
    }
}
