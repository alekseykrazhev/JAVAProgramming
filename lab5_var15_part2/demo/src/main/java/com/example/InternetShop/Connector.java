package com.example.InternetShop;
import java.util.*;
import java.io.*;

public class Connector
{
    private ArrayList<Client> masClients = new ArrayList<Client>();

    public Connector() {}

    public Connector(Client[] masClients) {
        for (Client pr : masClients)
            this.masClients.add(pr);

    }

    public Client[] getMasClients() {
        Client[] mas = new Client[masClients.size()];
        for (int i = 0; i < mas.length; i++)
            mas[i] = masClients.get(i);
        return mas;
    }

    public void setMasClients(Client[] mas_Clients) {
        if (!this.masClients.isEmpty())
            this.masClients.clear();
        for (Client pr : mas_Clients)
            this.masClients.add(pr);
    }

    public void addClient(Client Client) {
        masClients.add(Client);
    }

    public void clearClients() {
        if (!this.masClients.isEmpty())
            masClients.clear();
    }


    public void WriteAllDataToFile(String filename) throws Exception {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
            os.writeInt(masClients.size());
            for (Client pr : masClients) {
                os.writeObject(pr);
            }
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public void ReadAllDataFromFile(String filename) throws Exception
    {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
            int length = is.readInt();
            if (!this.masClients.isEmpty())
                masClients.clear();
            for (int i = 0; i < length; i++)
                masClients.add((Client) is.readObject());
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}