package com.example;

public class App 
{
    public static void main( String[] args )
    {
        String[] names = new String[10];
        for (int i = 0; i < 10; ++i){
            names[i] = "Name " + (i + 1);
        }

        int[][] marks = new int[10][5];
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                marks[i][j] = (int) (Math.random() * 100);
            }
        }

        Abiturient[] abiturients = new Abiturient[10];
        for(int i = 0; i < 10; i++) {
            abiturients[i] = new Abiturient(names[i], marks[i]);
            abiturients[i].Print();
            System.out.println();
        }

        Abiturient.ListOfPassedAbiturients(abiturients,250,4);
    }
}
