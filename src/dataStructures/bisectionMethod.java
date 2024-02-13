package dataStructures;

import java.util.Scanner;

public class bisectionMethod {
    public static void main(String[] args)
    {
        // initialize values
        double a;
        double b;

        // take user inputted values for a and b
        Scanner key = new Scanner(System.in);
        System.out.println("Enter Value of point a: ");
        a=key.nextDouble();

        System.out.println("Enter Value of point b: ");
        b=key.nextDouble();

        // call bisection method
        bisection(a, b);
        key.close();

    }

    static final float EPSILON = (float)0.01;

    // An example function whose solution is determined using
    static double func(double x)
    {
        return x*x*x - x*x + 2;
    }

    // Bisection Method. The function is x^3 - x^2  + 2
    // Prints root of func(x) with error of EPSILON
    static void bisection(double a, double b)
    {
        if (func(a) * func(b) >= 0)
        {
            System.out.println("You have not assumed" + " right a and b");
            return;
        }

        double c = a;
        while ((b-a) >= EPSILON)
        {
            // Find middle point
            c = (a+b)/2;

            // Check if middle point is root
            if (func(c) == 0.0)
                break;

                // Decide the side to repeat the steps
            else if (func(c)*func(a) < 0)
                b = c;
            else
                a = c;
        }
        //prints value of c upto 4 decimal places
        System.out.printf("The value of root is : %.4f", c);
    }

}
