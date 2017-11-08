package ru.opiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.opiti.technics.dao.TechnicsDAO;
import ru.opiti.technics.model.Technics;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WelcomeController {

    private TechnicsDAO technicsDAO;

//    @Value("${technicsList.holder}")
    private List<Technics> allTechnics;

    @RequestMapping("/")
    public String welcome(ModelMap model){
        technicsDAO = new TechnicsDAO();
        allTechnics = technicsDAO.listTechnics();
        model.addAttribute("holder", allTechnics.get(10).getHolder());

//        allTechnics = new ArrayList<Technics>();
//        allTechnics.add(new Technics("Ivan Petrov"));
//        allTechnics.add(new Technics("Semen Slepakov"));
//        allTechnics.add(new Technics("Dno Muchnoe"));
//        allTechnics.add(new Technics("Mosey Kotov"));
//        model.addAttribute("holder", allTechnics.get(0).getHolder());
        return "/index";
    }

}
