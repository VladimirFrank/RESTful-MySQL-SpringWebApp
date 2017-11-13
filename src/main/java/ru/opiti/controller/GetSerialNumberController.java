package ru.opiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.opiti.technics.dao.TechnicsDAO;
import ru.opiti.technics.model.Technics;

import java.util.List;

@Controller
public class GetSerialNumberController {

    private List<Technics> technicsListBySn;

    @RequestMapping("/getBySerialNumber")
    public String getBySerialNumber(@RequestParam(value = "snInput") String serialNumber, Model model){
        technicsListBySn = new TechnicsDAO().findTechnicsByFio(serialNumber);
        model.addAttribute("listOfTechnics", technicsListBySn);
        return "/technicsList";

    }

}
