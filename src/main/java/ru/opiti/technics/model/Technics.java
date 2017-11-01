package ru.opiti.technics.model;

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
    private String owner;
    private String comment;
    private String date;

    public Technics(String deviceType, String deviceName,
                    String serialNumber, String inventoryNumber,
                    String holder, String owner, String comment,
                    String date){
        this.deviceType = deviceType;
        this.deviceName = deviceName;
        this.serialNumber = serialNumber;
        this.inventoryNumber = inventoryNumber;
        this.holder = holder;
        this.owner = owner;
        this.comment = comment;
        this.date = date;
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
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Column(name = "description")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
                ", owner='" + owner + '\'' +
                ", comment='" + comment + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
