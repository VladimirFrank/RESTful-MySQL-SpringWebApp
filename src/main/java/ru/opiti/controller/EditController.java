package ru.opiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.opiti.technics.dao.TechnicsDAO;
import ru.opiti.technics.model.Technics;

@Controller
public class EditController {

    private Technics technicsToEdit;

    @RequestMapping("/edit")
    public String getEditTechnics(@RequestParam(value = "id") Integer id, Model model){
        technicsToEdit = new TechnicsDAO().findTechnicsById(id);
        if(technicsToEdit == null){
            return "/errorPage";
        }
        model.addAttribute("technicsToEdit", technicsToEdit);
        return "/editPage";
    }
}
