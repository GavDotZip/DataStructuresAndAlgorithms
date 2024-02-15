package dataStructures;

import java.util.Scanner;

public class solvingLinearEquations {
    public static void main(String[] args){
        Scanner key = new Scanner(System.in);
        char[] var = {'w', 'x', 'y', 'z'};
        System.out.println("Enter Number of Variables in the Equation: ");
        int num = key.nextInt();

        System.out.println("Enter Coefficient for each of the variables in the format ax + by + cz + ... = d: ");
        double [][]matrix = new double[num][num];
        double [][]constant = new double[num][num];

        key.close();
    }
}
