package com.InternetShop;

enum Type{pan, plate, spoon, phone,sneakers}

public class Goods {
    boolean sold;
    int cost;
    Type type;

    public Goods()
    {
        cost=0;
        type=null;
        sold=false;
    }
    public Goods(int cost,Type type)
    {
        this.cost=cost;
        this.type=type;
        this.sold=false;
    }
}
