package ru.opiti.technics.model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "alltechnics")
public class Technics implements Serializable {

    private static final long serialVersionUID = 3090254119266881638L;

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

    public Technics(String deviceType, String deviceName,
                    String serialNumber, String inventoryNumber,
                    String holder, String propertyOwner, String description,
                    String date){
        this.deviceType = deviceType;
        this.deviceName = deviceName;
        this.serialNumber = serialNumber;
        this.inventoryNumber = inventoryNumber;
        this.holder = holder;
        this.propertyOwner = propertyOwner;
        this.description = description;
        this.date = date;

    }

    public Technics(String holder){
        this.holder = holder;
    }

    public Technics(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "device_type")
    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Column(name = "device_name")
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Column(name = "serial_number")
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Column(name = "inventory_number")
    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    @Column(name = "holder")
    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    @Column(name = "property_owner")
    public String getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(String propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    @Override
    public String toString() {
        return "Technics{" +
                "id=" + id +
                ", deviceType='" + deviceType + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", inventoryNumber='" + inventoryNumber + '\'' +
                ", holder='" + holder + '\'' +
                ", owner='" + propertyOwner + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
