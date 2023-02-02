package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingController {
    @GetMapping(path = "/hello")
    public String greeting(@RequestParam String name,
                           @RequestParam(required = false, defaultValue = "VietNam") String country){
        return "Hello "+name+" from"+country;
    }

    @GetMapping(path = "/hello2")
    public Object greeting2(@RequestParam String name,
                            @RequestParam String country){
        Map<String, String> result = new HashMap<>();
        result.put("name", name);
        result.put("country", country);
        return result;
    }

    @GetMapping(path = "/hello3/{name}/{country}")
    public Object greeting3(@PathVariable String name,
                            @PathVariable String country){
        Map<String, String> result = new HashMap<>();
        result.put("name", name);
        result.put("country", country);
        return result;
    }
}
