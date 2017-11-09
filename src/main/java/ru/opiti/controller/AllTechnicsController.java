package ru.opiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.opiti.technics.dao.TechnicsDAO;
import ru.opiti.technics.model.Technics;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AllTechnicsController {

    private TechnicsDAO technicsDAO;

//    @Value("${technicsList.holder}")
    private List<Technics> allTechnics;

    @RequestMapping("/allTechnics")
    public String getAllTechnics(Model model){
        allTechnics = new TechnicsDAO().listTechnics();
//        model.addAttribute("holder", allTechnics.get(10).getHolder());
        model.addAttribute("listOfTechnics", allTechnics);
        return "/allTechnics";
    }



}
