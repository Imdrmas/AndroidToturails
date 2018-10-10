package com.issam.drmas.myhouse;

import java.util.Date;

public class Spend  {

    private String id;
    private String name;
    private String spend;
    private String time;
    private double price;
    private String title;

    public Spend(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpend() {
        return spend;
    }

    public void setSpend(String spend) {
        this.spend = spend;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Spend(String id, String name, String spend, String time, double price, String title) {
        this.id = id;
        this.name = name;
        this.spend = spend;
        this.time = time;
        this.price = price;
        this.title = title;
    }
}
