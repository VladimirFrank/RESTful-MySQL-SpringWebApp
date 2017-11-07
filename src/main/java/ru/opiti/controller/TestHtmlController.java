package ru.opiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sbt-filippov-vv on 03.11.2017.
 */

@Controller
public class TestHtmlController {

    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }

}
