package com.example.InternetShop;

import java.io.Serializable;

enum Type {
    pan, plate, spoon, phone, sneakers
}

public class Goods implements Serializable {
    boolean sold;
    int cost;
    Type type;

    public Goods() {
        cost = 0;
        type = null;
        sold = false;
    }

    public Goods(int cost, Type type) {
        this.cost = cost;
        this.type = type;
        this.sold = false;
    }
}
