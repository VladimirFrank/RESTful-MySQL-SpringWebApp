package ru.opiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController {

    @RequestMapping("/errorPage")
    public String getErrorPage(){
        return "/errorPage";
    }

}
