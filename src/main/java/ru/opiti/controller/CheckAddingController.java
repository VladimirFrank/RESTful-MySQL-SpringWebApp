package ru.opiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.opiti.technics.dao.TechnicsDAO;
import ru.opiti.technics.model.Technics;

@Controller
public class CheckAddingController {

    private TechnicsDAO technicsDAO;

    @RequestMapping("/checkAdding")
    public String getCheckAddingPage(@RequestParam("deviceType") String deviceType,
                                     @RequestParam("deviceName") String deviceName,
                                     @RequestParam("serialNumber") String serialNumber,
                                     @RequestParam("inventoryNumber") String inventoryNumber,
                                     @RequestParam("holder") String holder,
                                     @RequestParam("propertyOwner") String propertyOwner,
                                     @RequestParam("description") String description,
                                     @RequestParam("date") String date,
                                     @RequestParam("location") String location){


        technicsDAO = new TechnicsDAO();
        boolean successfulAdd = technicsDAO.addTechnics(new Technics(deviceType, deviceName, serialNumber, inventoryNumber,
                                             holder, propertyOwner, description, date, location));
        if(successfulAdd){
            return "/successfulUpdate";

        } else{
            return "/errorPage";
        }

    }
}
