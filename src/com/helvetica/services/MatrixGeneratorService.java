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
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
    }

}
