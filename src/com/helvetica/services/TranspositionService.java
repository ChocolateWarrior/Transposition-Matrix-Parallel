package com.helvetica.services;

public class TranspositionService {

    public int [][] getTransposed(int [][] matrix) {
        int dimension = matrix.length;
        int [][] transposedMatrix = new int [dimension][dimension];
        for (int col = 0; col < dimension; col++) {
            for (int row = 0; row < dimension; row++) {
                transposedMatrix[col][row] = matrix[row][col];
            }
        }
        return transposedMatrix;
    }

}
