package com.issc.second.entity;

import javax.persistence.*;

@Entity
@Table(name = "bussinesscar")
public class BussinessCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long bussinessId;

    private String carId;

    private String carType;

    private String carColor;

    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBussinessId() {
        return bussinessId;
    }

    public void setBussinessId(long bussinessId) {
        this.bussinessId = bussinessId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
