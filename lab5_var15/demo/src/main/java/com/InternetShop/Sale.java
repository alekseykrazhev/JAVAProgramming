package com.InternetShop;

import java.io.Serializable;

public class Sale implements Serializable{
    int cost;
    int number;

    public Sale()
    {
        cost=0;
        number=0;
    }
    public Sale(int cost,int number)
    {
        this.cost=cost;
        this.number=number;
    }
}
