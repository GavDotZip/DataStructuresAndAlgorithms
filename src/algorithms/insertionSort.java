package algorithms;

import java.util.InputMismatchException;
import java.util.Scanner;

public class insertionSort {
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

        insertionSort iS = new insertionSort();
        iS.InsertionSort(array);
        printArray(array);
        keyboard.close();
    }//end main method

    void InsertionSort(int[] array) {
        int n = array.length;
        for(int i=1; i<n; i++) {
            int keyPoint = array[i];
            int j = i-1;

            //move array elements greater than the keyPoint to one index later
            while (j>=0 && array[j] > keyPoint) {
                array[j + 1] = array[j];
                j=j-1;
            }//end while loop

            //set the new positon of j as the keyPoint
            array[j+1]=keyPoint;

        }//end for loop
    }//end method


    //fucntion to display the sorted array
    static void printArray(int[] arr) {
        System.out.println("List sorted via Insertion Sort");
        for (int j : arr) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }//end printArray


}//end class
