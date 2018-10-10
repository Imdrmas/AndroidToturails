package com.issam.drmas.myhouse;

public class Money {

    private String moneyId;
    private String name;
    private String money;
    private String time;
    private double price;

    public Money(){}


    public Money(String moneyId, String name, String money, String time, double price) {
        this.moneyId = moneyId;
        this.name = name;
        this.money = money;
        this.time = time;
        this.price = price;
    }

    public String getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(String moneyId) {
        this.moneyId = moneyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
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
}
