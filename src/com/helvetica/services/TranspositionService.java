package com.helvetica.services;

public class TranspositionService {

    public int [][] getTransposed(int [][] matrix) {
        int dimension = matrix.length;
        int [][] transposedMatrix = new int [dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

}
