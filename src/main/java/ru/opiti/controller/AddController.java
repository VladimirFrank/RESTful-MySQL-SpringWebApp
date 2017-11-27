package ru.opiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddController {

    @RequestMapping("/addPosition")
    public String getAddPositionPage(){
        return "/addPage";
    }
}
