package algorithms;

import java.util.InputMismatchException;
import java.util.Scanner;

// Java program for implementation of Selection Sort
class selectionSort {
    public static void main(String[] args) {
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
        //create a new SelectionSort object
        selectionSort sS = new selectionSort();
        sS.SelectionSort(array);
        printArray(array);
        keyboard.close();
    }

    void SelectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++)
        {
            //find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                if (array[j] < array[min_idx])
                    min_idx = j;
            }

            //swap the found minimum element with the first element
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
    }


    //function to display the sorted array
    static void printArray(int[] arr) {
        System.out.println("List sorted via Selection Sort");
        for (int j : arr) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }//end printArray

}