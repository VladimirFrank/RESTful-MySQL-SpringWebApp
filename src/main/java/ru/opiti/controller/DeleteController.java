package ru.opiti.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.opiti.technics.dao.TechnicsDAO;
import ru.opiti.technics.model.Technics;

@Controller
public class DeleteController {

    private Technics technicsToEdit;

    @RequestMapping("/deleteTechnics")
    public String deleteTechnics(@RequestParam(value = "id") Integer id){
        boolean deleteIsSuccess = new TechnicsDAO().deleteTechnics(id);
        if (deleteIsSuccess){
            return "/deleteIsSuccess";
        } else{
            return "/deleteError";
        }

    }
}
