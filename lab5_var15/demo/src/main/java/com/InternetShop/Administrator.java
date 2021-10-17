package com.InternetShop;

import java.io.Serializable;

public class Administrator implements Serializable{
    String name;

    public Administrator() {
        this.name = null;
    }

    public Administrator(String name) {
        this.name = name;
    }


    public void SetGood(Goods good, int cost, Type type) {
        good.cost = cost;
        good.type = type;
    }

    public void RegisterSale(Client client)
    {
        if(client.order.Sum()>client.money)
        {
            client.blackList=true;
        }
        else
        {
            client.money-=client.order.Sum();
            for(int i=0;i<5;i++)
            {
                client.order.goods[i].sold=true;
            }
        }
    }
}
