package ru.opiti.controller.filterController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.opiti.technics.dao.ColumnName;
import ru.opiti.technics.dao.TechnicsDAO;
import ru.opiti.technics.model.Technics;

import java.util.List;

@Controller
public class FilterTechnics {

    private List<Technics> technicsListFiltered;

    @RequestMapping("/filterByDeviceType")
    public String getByDeviceType(@RequestParam(value = "deviceType") String deviceType, Model model){

        technicsListFiltered = new TechnicsDAO().findTechnics(ColumnName.DEVICE_TYPE, deviceType);
        model.addAttribute("listOfTechnics", technicsListFiltered);
        return "/technicsList";
    }

    @RequestMapping("/filterByDeviceName")
    public String getByDeviceName(@RequestParam(value = "deviceName") String deviceName, Model model){

        technicsListFiltered = new TechnicsDAO().findTechnics(ColumnName.DEVICE_NAME, deviceName);
        model.addAttribute("listOfTechnics", technicsListFiltered);
        return "/technicsList";
    }

    @RequestMapping("/filterBySerialNumber")
    public String getBySerialNumber(@RequestParam(value = "serialNumber") String serialNumber, Model model){

        technicsListFiltered = new TechnicsDAO().findTechnics(ColumnName.SERIAL_NUMBER, serialNumber);
        model.addAttribute("listOfTechnics", technicsListFiltered);
        return "/technicsList";
    }

    @RequestMapping("/filterByInventoryNumber")
    public String getByInventoryNumber(@RequestParam(value = "inventoryNumber") String inventoryNumber, Model model){
        technicsListFiltered = new TechnicsDAO().findTechnics(ColumnName.INVENTORY_NUMBER, inventoryNumber);
        model.addAttribute("listOfTechnics", technicsListFiltered);
        return "/technicsList";
    }

    @RequestMapping("/filterByHolder")
    public String getByHolder(@RequestParam(value = "holder") String holder, Model model){

        technicsListFiltered = new TechnicsDAO().findTechnics(ColumnName.HOLDER, holder);
        model.addAttribute("listOfTechnics", technicsListFiltered);
        return "/technicsList";
    }

    @RequestMapping("/filterByPropertyOwner")
    public String getByPropertyOwner(@RequestParam(value = "propertyOwner") String propertyOwner, Model model){

        technicsListFiltered = new TechnicsDAO().findTechnics(ColumnName.PROPERTY_OWNER, propertyOwner);
        model.addAttribute("listOfTechnics", technicsListFiltered);
        return "/technicsList";
    }

    @RequestMapping("/filterByDescription")
    public String getByDescription(@RequestParam(value = "description") String description, Model model){

        technicsListFiltered = new TechnicsDAO().findTechnics(ColumnName.DESCRIPTION, description);
        model.addAttribute("listOfTechnics", technicsListFiltered);
        return "/technicsList";
    }

    @RequestMapping("/filterByDate")
    public String getByDate(@RequestParam(value = "date") String date, Model model){

        technicsListFiltered = new TechnicsDAO().findTechnics(ColumnName.DATE, date);
        model.addAttribute("listOfTechnics", technicsListFiltered);
        return "/technicsList";
    }

    @RequestMapping("/filterByLocation")
    public String getByLocation(@RequestParam(value = "location") String location, Model model){

        technicsListFiltered = new TechnicsDAO().findTechnics(ColumnName.LOCATION, location);
        model.addAttribute("listOfTechnics", technicsListFiltered);
        return "/technicsList";
    }

}
