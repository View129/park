package com.issc.second.entity;

import javax.persistence.*;

@Entity
@Table(name = "carseat")
public class CarSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String position;

    private long memberId;

    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
