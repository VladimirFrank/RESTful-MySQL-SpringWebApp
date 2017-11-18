package ru.opiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.opiti.technics.dao.TechnicsDAO;
import ru.opiti.technics.model.Technics;

@Controller
public class CheckEditController {

    TechnicsDAO technicsDAO;

    @RequestMapping("/checkEdit")
    public String getCheckEdit(@RequestParam("id") Integer id,
                               @RequestParam("deviceType") String deviceType,
                               @RequestParam("deviceName") String deviceName,
                               @RequestParam("serialNumber") String serialNumber,
                               @RequestParam("inventoryNumber") String inventoryNumber,
                               @RequestParam("holder") String holder,
                               @RequestParam("propertyOwner") String propertyOwner,
                               @RequestParam("description") String description,
                               @RequestParam("date") String date,
                               @RequestParam("location") String location){
        technicsDAO = new TechnicsDAO();
        Technics updatableTechnics = technicsDAO.findTechnicsById(id);

        updatableTechnics.setDeviceType(deviceType);
        updatableTechnics.setDeviceName(deviceName);
        updatableTechnics.setSerialNumber(serialNumber);
        updatableTechnics.setInventoryNumber(inventoryNumber);
        updatableTechnics.setHolder(holder);
        updatableTechnics.setPropertyOwner(propertyOwner);
        updatableTechnics.setDescription(description);
        updatableTechnics.setDate(date);
        updatableTechnics.setLocation(location);

        technicsDAO.updateTechnics(updatableTechnics);
        return "/successfulUpdate";
    }
}
