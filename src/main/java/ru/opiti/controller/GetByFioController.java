package ru.opiti.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.opiti.technics.dao.TechnicsDAO;
import ru.opiti.technics.model.Technics;

import java.util.List;

@Controller
public class GetByFioController {

    private List<Technics> technicsListByFio;

    @RequestMapping(value = "/getByFio")
    public String getByFio(@RequestParam(value = "fioInput") String fio, Model model){

        technicsListByFio = new TechnicsDAO().findTechnicsByFio(fio);
        if(technicsListByFio == null || technicsListByFio.size() == 0){
            return "/errorPage";
        }
        model.addAttribute("listOfTechnics", technicsListByFio);
        return "/technicsList";
    }
}
