package com.InternetShop;

import java.util.Date;
import java.util.ResourceBundle;

import java.io.Serializable;

public class Client implements Serializable{
    String name;
    int money;
    boolean blackList;
    Order order;
    private Date date= new Date();

    transient public ResourceBundle bundle=ResourceBundle.getBundle("MSG");


    public Client()
    {
        name=null;
        money=0;
        blackList=false;
        order=null;
    }

    public Client(String name,int money,Order order)
    {
        this.name=name;
        this.money=money;
        this.blackList=false;
        this.order=order;

    }

    public Date getDate()
    {
        return this.date;
    }

    public void print()
    {
        System.out.println(bundle.getString("Name")+name);
        System.out.println(bundle.getString("Money")+money);
        if(blackList)
        {
            System.out.println(bundle.getString("In_blacklist"));
        }
        else
            System.out.println(bundle.getString("NOT_in_blacklist"));
        System.out.println(bundle.getString("Number_of_order")+this.order.number);
        System.out.println(bundle.getString("Date")+date);
        System.out.println();
    }
}
