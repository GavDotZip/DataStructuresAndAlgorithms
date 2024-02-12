package algorithms;

import java.util.InputMismatchException;
import java.util.Scanner;

public class bubbleSort {
    public static void main(String[] args) {
        int num=0;
        int i;
        int x;
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
        //user inputs the pre-specified number of integers
        System.out.println("Enter " + num + " Integers: ");
        //for loop to store the integers as elements of the array
        for(i=0; i<num; i++) {
            array[i] = keyboard.nextInt();
        }//end for loop

        //use of a nested for loop to order the list in terms of all elements
        for (i=0; i<num-1;i++) {
            for(x=0; x<num-1;x++) {

                //if the element at [x] is greater than the following element
                if(array[x] > array[x+1]) {
                    //set integer 'temp' as element [x]
                    int temp = array[x];
                    //we swap [x] with the following element
                    array[x] = array[x+1];
                    //set temp as the new element
                    array[x+1]=temp;
                }//end if

            }//end for
        }//end for


        System.out.println("List sorted via Bubble Sort");
        for(i = 0; i<num; i++) {
            System.out.print(array[i] + "\t");
        }//end for loop
        keyboard.close();
    }//end main method

}//end class