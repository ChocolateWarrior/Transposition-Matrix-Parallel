package com.helvetica.services;

public class PrintService {

    public static final String FINISHED_IN = "Finished in %s ms";
    public static final String IMPROVEMENT = "Speed Improvement: %s";
    public static final String EFFICIENCY = "Efficiency: %s";
    public static final String THREAD_NUM = "Thread number: %s";
    public static final String SPACE = " ";

    public static void printMatrix(int [][] matrix) {
        final int dimension = matrix.length;
        for (int[] col : matrix) {
            StringBuilder currentRow = new StringBuilder();
            for (int row = 0; row < dimension; row++) {
                currentRow.append(col[row]).append(SPACE);
            }
            System.out.println(currentRow);
        }
    }

    public static void print (String msg){
        System.out.println(msg);
    }

    public static void printThreads(int num) {
        System.out.printf(THREAD_NUM, num);
        System.out.println();
    }

    public static void printFinished(long time) {
        System.out.printf(FINISHED_IN, time);
        System.out.println();
    }

    public static void printImprovement(double num) {
        if(Double.isNaN(num)){
            System.out.printf(IMPROVEMENT, "no improvement");
        } else {
            System.out.printf(IMPROVEMENT, num);
        }
        System.out.println();
    }

    public static void printEfficiency(double num) {
        if(Double.isNaN(num)){
            System.out.printf(EFFICIENCY, "no improvement");
        } else {
            System.out.printf(EFFICIENCY, num);
        }
        System.out.println();
    }

    public static void printBlank(){
        System.out.println();
    }
}
