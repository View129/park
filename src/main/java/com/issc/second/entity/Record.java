package com.issc.second.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 车辆进出信息
 */
@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carId;

    private String carSeatId;

    private Long entranceId;

    private Long exitId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date  inTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date outTime;

    private String inImage;

    private String outImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getEntranceId() {
        return entranceId;
    }

    public void setEntranceId(Long entranceId) {
        this.entranceId = entranceId;
    }

    public Long getExitId() {
        return exitId;
    }

    public void setExitId(Long exitId) {
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
