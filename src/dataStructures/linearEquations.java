package dataStructures;

import java.util.Scanner;

public class linearEquations {
    public static void main(String[] args){
        Scanner key = new Scanner(System.in);

        //define the three variables for linear equations
        char[] variables = {'x', 'y', 'z'};
        System.out.println("Enter Coefficient for 3 variables in te format 'ax + by + cz = d': ");
        int[][] matrix = new int[3][3]; //represent the equation as a 3x3 matrix
        int[][] constant = new int[3][1];

        //iterate rows with an outer loop
        for(int i=0; i<3; i++){
            //iterate columns with inner loop
            for(int j=0; j<3; j++){
                //read user values from within the loop to fill matrix
                matrix[i][j] = key.nextInt();
            }
            //one row has completed, now define column
            constant[i][0] = key.nextInt();
        }

        System.out.println("Matrix Represenation of Equation: ");

        //Outer loop for iterating rows
        for(int i=0; i<3; i++){
            //inner lop for iterating columns
            for(int j=0; j<3; j++){
                System.out.print(" " + matrix[i][j]);
            }
            //print matrix representation
            System.out.print(" \t  " + variables[i]);
            System.out.print(" = " + constant[i][0]);
            System.out.println();
        }

        key.close();
    }

}
