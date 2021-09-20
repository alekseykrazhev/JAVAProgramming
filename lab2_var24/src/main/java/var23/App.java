package var23;

import java.util.Scanner;
import java.util.Random;

public class App {
    public static void fillRandom(int a[][], int d) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[j][i] = random.nextInt(2 * d + 1) - d;
            }
        }
    }

    public static void printArr(int[][] a) {

        for (int[] x : a) {
            for (int z : x) {
                System.out.print(z + "  ");
            }
            System.out.println();
        }

    }

    public static int[] columnSum(int[][] arr) {
        int[] sums = new int[arr.length];
        int sum = 0;

        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr.length; ++j) {
                sum += Math.abs(arr[j][i]);
            }
            sums[i] = sum;
            sum = 0;
        }
        return sums;
    }

    public static void changeColumns(int[][] arr, int a, int b, int size) {
        for (int i = 0; i < size; i++) {
            int temp = arr[i][a];
            arr[i][a] = arr[i][b];
            arr[i][b] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter n:");
        int size = scan.nextInt();
        scan.close();

        int arr[][] = new int[size][size];
        fillRandom(arr, size);
        printArr(arr);

        int[] sums = columnSum(arr);
        for (int j = 0; j < size; ++j) {
            for (int i = 0; i < sums.length - 1; ++i) {
                if (sums[i] < sums[i + 1]) {
                    int temp = sums[i];
                    sums[i] = sums[i + 1];
                    sums[i + 1] = temp;
                    changeColumns(arr, i, i + 1, size);
                }
            }
        }
        
        System.out.println("///////////////////////////////////");
        printArr(arr);
    }
}
