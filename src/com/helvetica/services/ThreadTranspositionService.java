package com.helvetica.services;

import com.helvetica.thread.TranspositionThread;

public class ThreadTranspositionService {

    private final int [][] transposedMatrix;

    public ThreadTranspositionService(int[][] transposedMatrix) {
        this.transposedMatrix = transposedMatrix;
    }

    public void transpositionParallel(int numThreads, int [][] matrix) throws InterruptedException {
        TranspositionThread[] threads = new TranspositionThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new TranspositionThread(matrix, transposedMatrix, i);
            threads[i].start();
        }
        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }
        for (int i = 0; i < numThreads; i++) {
            this.transposedMatrix[i] = threads[i].getMatrixToTransposition()[i];
        }
    }

    public int[][] getTransposedMatrix() {
        return transposedMatrix;
    }
}
