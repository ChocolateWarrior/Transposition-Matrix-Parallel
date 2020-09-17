package com.helvetica.services;

import com.helvetica.thread.TranspositionThread;

public class ThreadTranspositionService {

    private final int[][] transposedMatrix;

    public ThreadTranspositionService(int[][] transposedMatrix) {
        this.transposedMatrix = transposedMatrix;
    }

    public void transpositionParallel(int numThreads, int[][] matrix) throws InterruptedException {
        int dimensionNum = matrix.length;
        int rowPerThread = (dimensionNum + numThreads - 1)/numThreads;
        int lastThreadRowNum = getLastThreadRowNum(dimensionNum, rowPerThread);
        TranspositionThread[] threads = new TranspositionThread[numThreads];

        for (int threadNumber = 0; threadNumber < numThreads; threadNumber++) {
            if(isLastThread(numThreads, threadNumber)){
                threads[threadNumber] = new TranspositionThread(matrix, transposedMatrix,
                        threadNumber, lastThreadRowNum, rowPerThread);
            } else {
                threads[threadNumber] = new TranspositionThread(matrix, transposedMatrix,
                        threadNumber, rowPerThread, rowPerThread);
            }
            threads[threadNumber].start();
        }

        for (int threadNumber = 0; threadNumber < numThreads; threadNumber++) {
            threads[threadNumber].join();
        }

        for (int threadNumber = 0; threadNumber < numThreads; threadNumber++) {
            for(int row = 0; row < threads[threadNumber].getRowPerThread(); row++){
                int currentRow = threadNumber * rowPerThread + row;
                this.transposedMatrix[currentRow] = threads[threadNumber].getMatrixToTransposition()[currentRow];
            }
        }
    }

    private int getLastThreadRowNum(int dimensionNum, int rowPerThread) {
        return dimensionNum % rowPerThread == 0 ? rowPerThread : dimensionNum % rowPerThread;
    }

    public int[][] getTransposedMatrix() {
        return transposedMatrix;
    }

    private boolean isLastThread(int numThreads, int threadNumber) {
        return threadNumber == numThreads - 1;
    }
}
