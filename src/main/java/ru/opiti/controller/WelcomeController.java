package ru.opiti.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.opiti.technics.dao.TechnicsDAO;
import ru.opiti.technics.model.Technics;

import java.util.List;
import java.util.Map;

/**
 * Created by sbt-filippov-vv on 02.11.2017.
 */

@Controller
public class WelcomeController {

    private TechnicsDAO technicsDAO;

    @Value("${technicsList}")
    private List<Technics> allTechnics;

    @RequestMapping("/")
    public String welcome(ModelMap model){
        technicsDAO = new TechnicsDAO();
        allTechnics = technicsDAO.listTechnics();
        model.addAttribute("allTechnics", allTechnics);
        return "/index";
    }

}
