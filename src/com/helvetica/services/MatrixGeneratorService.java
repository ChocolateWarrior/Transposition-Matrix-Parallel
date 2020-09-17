package com.helvetica.services;

public class MatrixGeneratorService {

    public static int [][] generate(final int dimension) {
        int [][] matrix = new int[dimension][dimension];
        populateMatrix(matrix);
        return matrix;
    }

    public static int [][] generateEmpty(final int dimension) {
        return new int [dimension][dimension];
    }

    private static void populateMatrix(int[][] matrix) {
        for (int cols = 0; cols < matrix.length; cols++) {
            for (int rows = 0; rows < matrix.length; rows++) {
                matrix[cols][rows] = (int) (Math.random() * 10);
            }
        }
    }

}
