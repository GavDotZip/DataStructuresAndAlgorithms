package dataStructures;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class quadraticEquations {

    public static void main(String[] Strings) {
        //initialise Scanner and Formatter for 2 decimal places
        Scanner key = new Scanner(System.in);
        NumberFormat format00 = new DecimalFormat("#0.00");

        //prompt user for doubles
        System.out.print("Enter the value of a: ");
        double a = key.nextDouble();
        System.out.print("Enter the value of b: ");
        double b = key.nextDouble();
        System.out.print("Enter the value of c: ");
        double c = key.nextDouble();

        //using values a, b and c, calculate value d
        double d= b * b - 4.0 * a * c;
        System.out.println("\nd is found by the formula: b * b - 4.0 * a * c ");
        System.out.println("Value of d is: " + b + " *" + " " + b + " " + "- " +  "4.0" + " *" + " " + a +  " *" + " " + c + " = " + d);

        //if value of d is greater than 0, calculate both roots
        if (d> 0.0) {
            double root1 = (-b + Math.pow(d, 0.5)) / (2.0 * a);
            double root2 = (-b - Math.pow(d, 0.5)) / (2.0 * a);
            System.out.println("\nThe roots are " + format00.format(root1) + " and " + format00.format(root2));
            System.out.println("**Numbers rounded to two decimal places**\n");
        }

        //if value of d is equal to 0, find root1
        else if (d == 0.0) {
            double root1 = -b / (2.0 * a);
            System.out.println("\nThe root is " + format00.format(root1));
            System.out.println("**Numbers rounded to two decimal places** \n");

        }

        else {
            System.out.println("\nRoots are not real.\n");
        }

        key.close();
    }
}
