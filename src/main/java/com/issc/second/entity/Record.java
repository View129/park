package com.issc.second.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String carId;

    private String carSeatId;

    private long entranceId;

    private long exitId;

    private Date  inTime;

    private Date  outTime;

    private String inImage;

    private String outImage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarSeatId() {
        return carSeatId;
    }

    public void setCarSeatId(String carSeatId) {
        this.carSeatId = carSeatId;
    }

    public long getEntranceId() {
        return entranceId;
    }

    public void setEntranceId(long entranceId) {
        this.entranceId = entranceId;
    }

    public long getExitId() {
        return exitId;
    }

    public void setExitId(long exitId) {
        this.exitId = exitId;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getInImage() {
        return inImage;
    }

    public void setInImage(String inImage) {
        this.inImage = inImage;
    }

    public String getOutImage() {
        return outImage;
    }

    public void setOutImage(String outImage) {
        this.outImage = outImage;
    }
}
