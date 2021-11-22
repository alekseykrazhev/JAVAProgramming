package lab6;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        try {
            System.out.println("+++     UTILITY   BILL    +++\n");

            // Creating .dat file and writing some objects from Input.txt
            FileSupport datFile = new FileSupport("UtilityBill.dat");
            datFile.appendToFileFromTXTFile("Input.txt");
            Scanner input = new Scanner(System.in);
            System.out.println("Use command line args - 1, System.in - 2");
            int choise = input.nextInt();
            int userChoise = 0;
            switch (choise) {
                case 1:
                    if (args.length != 1) {
                        System.out.println ("invalid args input");
                        System.exit(1);
                    }
                    userChoise = Integer.parseInt(args[0]);
                    break;
                case 2:
                    System.out.println("___What do you want to do?___");
                    System.out.println("1. Append bill to file.");
                    System.out.println("2. Print file.");
                    System.out.println("_____________________________");
                    System.out.print("Your choice: ");
    
                    userChoise = input.nextInt();
                    break;
                default:
                    System.out.println("Invalid input");
                    System.exit(1);
            }

            System.out.println();

            switch (userChoise) {
            case 1:
                System.out.println("Enter Utility Bill:  ");
                Scanner in = new Scanner(System.in);
                String s = in.nextLine();
                datFile.appendToFile(new UtilityBill(s));

                System.out.println("After appending, .dat file: ");
                datFile.printFile();
                break;
            case 2:
                datFile.printFile();
                break;
            default:
                System.out.println("Incorrect input!");
                break;
            }

            System.out.println("\n\nThe program worked correctly!");
            input.close();
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }

    }
}
