package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex(){
        return "index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String showAdmin(Model model){
        model.addAttribute("message", "called to controller");
        return "admin";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showUser(){
        return "user";
    }
}
