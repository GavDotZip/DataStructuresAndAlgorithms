package algorithms;

import java.util.InputMismatchException;
import java.util.Scanner;

public class quickSort {
    public static void main (String[] args) {
        int num=0;
        int i;
        Scanner keyboard = new Scanner(System.in);

        while(num==0){//enter number of integers to input
            try {
                System.out.print("Enter Number of Integers to be Sorted: ");
                num=keyboard.nextInt();
            } catch (InputMismatchException ex) {//if integer not entered, prompt user
                System.out.println("Exception thrown :" + ex);
                System.out.println("Enter an Integer");
            }
            keyboard.nextLine();
        }

        //define the array
        int[] array = new int[num];
        System.out.println("Enter " + num + " Integers: ");

        //for loop to store the integers as elements of the array
        for(i=0; i<num; i++) {
            array[i] = keyboard.nextInt();
        }
        int n = array.length;

        quickSort qS = new quickSort();
        qS.sort(array, 0, n-1);
        printArray(array);
        keyboard.close();
    }//end main

    int QuickSort(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low-1); //index of smaller element
        for (int j=low; j<high; j++) {
            //if current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                i++;

                //swap arr[i] and arr[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        //swap array[i+1] and array[high] or the pivot value
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;

    }

    void sort(int[] array, int low, int high) {
        if (low < high) {
            //pi is used as the partitioning index
            int pi = QuickSort(array, low, high);

            //sorts elements recursively
            sort(array, low, pi-1);
            sort(array, pi+1, high);
        }

    }//end quickSort

    static void printArray(int[] array) {
        System.out.println("List Sorted via Quick Sort");
        for (int j : array) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }//end printArray

}
