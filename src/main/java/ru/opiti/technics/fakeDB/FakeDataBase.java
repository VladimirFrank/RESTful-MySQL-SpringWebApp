package ru.opiti.technics.fakeDB;

import java.util.ArrayList;
import java.util.List;

public class FakeDataBase {

    private Integer id;
    private String deviceType;
    private String deviceName;
    private String serialNumber;
    private String inventoryNumber;
    private String holder;
    private String propertyOwner;
    private String description;
    private String date;
    private String location;

    private static List<FakeDataBase> fakeTechnicsList = new ArrayList<FakeDataBase>();

    static{
        fakeTechnicsList.add(new FakeDataBase(1, "deviceType1", "deviceName1", "12345",
                "11788923", "Иванов Иван", "ООО Вектор", "",
                "01.01.1900", "Новосибирск"));
        fakeTechnicsList.add(new FakeDataBase(2, "deviceType2", "deviceName2", "12354",
                "12345", "Петров Петр", "ООО Вектор", "",
                "01.01.1900", "Новосибирск"));
        fakeTechnicsList.add(new FakeDataBase(3, "deviceType3", "deviceName3", "178825",
                "12123", "Сидоров Сидр", "ООО Вектор", "",
                "01.01.1900", "Новосибирск"));
        fakeTechnicsList.add(new FakeDataBase(4, "deviceType4", "deviceName4", "1112345",
                "121673", "Тимуров Тимур", "ООО Вектор", "",
                "01.01.1900", "Новосибирск"));
        fakeTechnicsList.add(new FakeDataBase(5, "deviceType5", "deviceName5", "1232345",
                "124123", "Джонов Джон", "ООО Вектор", "",
                "01.01.1900", "Новосибирск"));
        fakeTechnicsList.add(new FakeDataBase(6, "deviceType6", "deviceName6", "1232445",
                "12343", "Орлов Орел", "ООО Вектор", "",
                "01.01.1900", "Новосибирск"));
    }

    public FakeDataBase(Integer id, String deviceType, String deviceName, String serialNumber,
                        String inventoryNumber, String holder, String propertyOwner,
                        String description, String date, String location) {
        this.id = id;
        this.deviceType = deviceType;
        this.deviceName = deviceName;
        this.serialNumber = serialNumber;
        this.inventoryNumber = inventoryNumber;
        this.holder = holder;
        this.propertyOwner = propertyOwner;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    public static List<FakeDataBase> getFakeTechnicsList() {
        return fakeTechnicsList;
    }
}
