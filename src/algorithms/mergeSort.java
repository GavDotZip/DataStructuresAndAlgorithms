package algorithms;

import java.util.InputMismatchException;
import java.util.Scanner;

public class mergeSort {
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
        //create a new MergeSort object
        mergeSort mS = new mergeSort();
        //sort the new MergeSort object to display
        mS.MergeSort(array, 0, array.length-1);
        printArray(array);
        keyboard.close();
    }//end main method

    //function in which recursion will take place
    void MergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left+right)/2;//determine the middle of the array
            //recursive call to each sub array
            MergeSort(array, left, middle);
            MergeSort(array, middle + 1, right);

            //we then have to merge these sorted arrays
            merge(array, left, middle, right);//call the emrge function
        }
    }

    //function which will merge sub arrays
    void merge(int[] array, int a, int b, int c) {
        //need to find sizes of two sub arrays to be merged
        int new1 = b - a + 1;
        int new2 = c - b;
        //asign arrays to these values
        int[] leftArray = new int[new1];
        int[] rightArray = new int[new2];

        //now we can fill these new arrays to use as sub arrays
        System.arraycopy(array, a, leftArray, 0, new1);
        for( int j=0; j<new2; j++) {
            rightArray[j] = array[b+1+j];
        }

        // maintain indexes of temporary arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = a;

        // pick larger elements within sub arrays and place in sorted position
        while(i < new1 && j < new2) {
            if(leftArray[i] <= rightArray[j]) {
                // array[k] will act as smaller side of sub array
                array[k] = leftArray[i];
                i++;
            }
            else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }//end while

        //when elements run out, we pick up the remaining elements
        while(i<new1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
    }



    //fucntion to display the sorted array
    static void printArray(int[] arr) {
        System.out.println("List sorted via Merge Sort");
        for (int j : arr) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }//end function

}//end class

