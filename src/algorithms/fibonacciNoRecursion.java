package algorithms;

import java.util.Scanner;

public class fibonacciNoRecursion {
    public static void main(String[] args) {
        //define variable to be used within algorithm
        int n, a, b = 0, c = 1;
        Scanner key = new Scanner(System.in);
        //request user to input value n to which we will print the series
        System.out.print("Enter value of n, n being a positive whole number: ");
        n = key.nextInt();

        //check to see if n is a positive whole number or 0
        if(n>=0) {
            System.out.print("Fibonacci Series to value of n: ");

            //use variable to define the series
            for(int i = 1; i <= n; i++) {
                a = b;
                b = c;
                c = a + b;
                //in fibonacci, a number will always equal the sum of previous numbers in the sequence
                System.out.print(a+" ");// a being 0, print the series after up until the nth value inputted
            }


            key.close();
        }
        //if n < 0, terminate program
        else {
            System.out.println("Program terminated, enter a positive whole number");
        }

    }
}
