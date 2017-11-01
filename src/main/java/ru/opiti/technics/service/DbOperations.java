package ru.opiti.technics.service;

import ru.opiti.technics.dao.TechnicsDAO;
import ru.opiti.technics.model.Technics;

import java.util.List;

public class DbOperations {

    TechnicsDAO technicsDAO = new TechnicsDAO();

    public static void main(String[] args){
        DbOperations dbOperations = new DbOperations();
        Technics createTechnics = TechnicsDAO

        List<Technics> technicsList = dbOperations.getTechnicsList();
//        if(technicsList != null){
//            for(Technics technics : technicsList){
//                System.out.println("Holder: " + technics.getHolder() + "\n");
//            }
//        }
        System.out.println();
    }

    public Technics createTechnics(){
        Technics t = new Technics();
        t.setDeviceType("Девайс из hibernate");
        t.setDeviceName("Имя девайса");
        t.setSerialNumber("00000AAA");
        t.setInventoryNumber("00001111");
        t.setHolder("Яков Яков Якович");
        t.setOwner("Сбертех.");
        t.setComment("HIBERNATE!");
        t.setDate("01.01.1970");
        technicsDAO.addTechnics(t);
        return t;
    }

    public void updateTechnics(Integer id){
        Technics technics = technicsDAO.findTechnicsById(id);
        technics.setOwner("Мистер ХХХ");
        technicsDAO.updateTechnics(technics);
        System.out.println("Update success!");
    }

    public void deleteTechnics(Integer id){
        technicsDAO.deleteTechnics(id);
        System.out.println("Delete success!");
    }

    public List<Technics> getTechnicsList(){
        return technicsDAO.listTechnics();
    }

    public Technics getTechnics(Integer id){
        return technicsDAO.findTechnicsById(id);
    }
}
