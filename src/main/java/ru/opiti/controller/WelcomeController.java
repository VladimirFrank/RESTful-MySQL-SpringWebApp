package ru.opiti.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by sbt-filippov-vv on 02.11.2017.
 */

@Controller
public class WelcomeController {

    @Value("${welcome.message:test}")
    private String message = "Hello!";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model){
        model.put("message", this.message);
        return "welcome";
    }

}
