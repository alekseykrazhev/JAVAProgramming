package com.example;

public class Abiturient {
    private int[] marks;
    private String name;

    public Abiturient() {}

    public Abiturient(String _name) {
        name = _name;
    }

    public Abiturient(String _name, int[] _marks) {
        name = _name;
        marks = _marks;
    }

    public int SumOfMarks () {
        int sum = 0;
        for (int i : marks) {
            sum += i;
        }
        return sum;
    }

    public void Print () {
        System.out.println("Name: " + this.name + "\nMarks: ");
        for (int i : marks) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Sum of marks: " + this.SumOfMarks());
    }

    public static void ListOfPassedAbiturients (Abiturient[] abs, int requiredMark, int amount) {
        System.out.println ("Passed abiturients: ");

        if (amount >= abs.length) {
            System.out.println("Amount of places is bigger or the same as number of abiturients");
            return;
        }

        int passed = 0;
        for (int i = 0; i < amount; ++i) {
            if (abs[i].SumOfMarks() >= requiredMark) {
                ++passed;
                System.out.println ((i + 1) + ") " + abs[i].name + ' ' + abs[i].SumOfMarks());
            }
        }

        if (passed == 0) {
            System.out.println("Nobody passed");
        }
    }
}
