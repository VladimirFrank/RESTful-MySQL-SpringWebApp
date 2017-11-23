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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Technics technics = (Technics) o;

        if (!id.equals(technics.id)) return false;
        if (deviceType != null ? !deviceType.equals(technics.deviceType) : technics.deviceType != null) return false;
        if (deviceName != null ? !deviceName.equals(technics.deviceName) : technics.deviceName != null) return false;
        if (serialNumber != null ? !serialNumber.equals(technics.serialNumber) : technics.serialNumber != null)
            return false;
        if (inventoryNumber != null ? !inventoryNumber.equals(technics.inventoryNumber) : technics.inventoryNumber != null)
            return false;
        if (holder != null ? !holder.equals(technics.holder) : technics.holder != null) return false;
        if (propertyOwner != null ? !propertyOwner.equals(technics.propertyOwner) : technics.propertyOwner != null)
            return false;
        if (description != null ? !description.equals(technics.description) : technics.description != null)
            return false;
        if (date != null ? !date.equals(technics.date) : technics.date != null) return false;
        return location != null ? location.equals(technics.location) : technics.location == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (deviceType != null ? deviceType.hashCode() : 0);
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (inventoryNumber != null ? inventoryNumber.hashCode() : 0);
        result = 31 * result + (holder != null ? holder.hashCode() : 0);
        result = 31 * result + (propertyOwner != null ? propertyOwner.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
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
