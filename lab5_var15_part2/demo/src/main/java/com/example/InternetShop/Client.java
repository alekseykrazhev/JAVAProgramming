package com.example.InternetShop;

import java.util.Date;

import java.io.Serializable;

public class Client implements Serializable {
    String name;
    int money;
    boolean blackList;
    Order order;
    private Date date = new Date();

    public Client() {
        name = null;
        money = 0;
        blackList = false;
        order = null;
    }

    public Client(String name, int money, Order order) {
        this.name = name;
        this.money = money;
        this.blackList = false;
        this.order = order;

    }

    public Date getDate() {
        return this.date;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Money: " + money);
        if (blackList) {
            System.out.println("In blacklist ");
        } else
            System.out.println("NOT in blacklist ");
        System.out.println("Number of order: " + this.order.number);
        System.out.println("Date: " + date);
        System.out.println();
    }
}
