package com.issc.second.entity;

import javax.persistence.*;

/**
 * 入口
 */
@Entity
@Table(name = "entrance")
public class Entrance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String entrancename;

    private String position;

    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEntrancename() {
        return entrancename;
    }

    public void setEntrancename(String entrancename) {
        this.entrancename = entrancename;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
