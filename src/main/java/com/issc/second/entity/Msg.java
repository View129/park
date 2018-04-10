package com.issc.second.entity;

import java.util.HashMap;
import java.util.Map;

public class Msg {

    private int code;

    private String message;

    private Map<String,Object> map = new HashMap<String,Object>();

    public static final Msg ERROR = new Msg(0,"error");
    public static final Msg SUCCESS = new Msg(1,"success");

    public Msg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Msg add(String key,Object value){
        this.getMap().put(key,value);
        return this;
    }

    public Msg() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}