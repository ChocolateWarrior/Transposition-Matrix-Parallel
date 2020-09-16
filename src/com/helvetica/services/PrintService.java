package com.helvetica.services;

public class PrintService {

    public static final String FINISHED_IN = "Finished in '%s' ms";
    public static final String IMPROVEMENT = "Improvement: '%s'";
    public static final String SPACE = " ";

    public static void printMatrix(int [][] matrix) {
        final int dimension = matrix.length;
        for (int[] ints : matrix) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < dimension; j++) {
                row.append(ints[j]).append(SPACE);
            }
            System.out.println(row);
        }
    }

    public static void print (String msg){
        System.out.println(msg);
    }

    public static void printFinished (long time){
        System.out.printf(FINISHED_IN, time);
        System.out.println();
    }

    public static void printImprovement (double num){
        System.out.printf(IMPROVEMENT, num);
        System.out.println();
    }

    public static void printBlank (){
        System.out.println();
    }
}
