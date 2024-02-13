package algorithms;

import java.util.Scanner;

public class fibonacciRecursion {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = key.nextInt();
        if(n>=0) {
            //call the function which will calculate to the nth value
            fibonacci(n);
        }
        else {
            System.out.println("Program terminated, enter a positive whole number");
        }
        key.close();

    }//end main

    //use a for loop in order to define the series
    public static void fibonacci(int number){
        for(int i=0; i <= number; i++){
            System.out.print(getFibonacci(i) + " ");
        }//end for
    }//end fibonacci

    //here we will caclulate the series up until the nth number
    public static int getFibonacci(int n){
        //if user enter 0 or 1, we can simply print them out
        if (n == 0) {
            return 0;
        }

        if (n == 1){
            return 1;
        }

        //much like using no recursion, we define how a + b = c
        int a = 0;
        int b = 1;
        int c = 1;
        //use these variable to define the series
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        //return c, as c must always be the content of the series
        return c;

    }//end getFibonacci


}
