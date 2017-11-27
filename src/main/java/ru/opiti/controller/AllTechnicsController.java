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
import java.util.Set;

@Controller
public class AllTechnicsController {

    private List<Technics> allTechnics;

    @RequestMapping("/technicsList")
    public String getAllTechnics(Model model){
        allTechnics = new TechnicsDAO().listTechnics();
        model.addAttribute("listOfTechnics", allTechnics);
        return "/technicsList";
    }

}
