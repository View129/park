package com.issc.second.entity;

import java.util.HashMap;
import java.util.Map;

public class Msg<T>{

    private int code;

    private String message;

    private Map<String,T> map = new HashMap<String,T>();

    public static Msg setSuccess(){
        return new Msg(1,"SUCCESS");
    }

    public static Msg setError(){
        return new Msg(0,"ERROR");
    }

    public Msg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Msg add(String key, T value){
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

    public Map<String, T> getMap() {
        return map;
    }

    public void setMap(Map<String, T> map) {
        this.map = map;
    }
}