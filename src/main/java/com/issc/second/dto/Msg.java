package com.issc.second.dto;

public class Msg<T>{

    private int code;

    private String message;

    private T data ;

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
        this.setData(value);
        return this;
    }
    public Msg add(T value){
        this.setData(value);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}