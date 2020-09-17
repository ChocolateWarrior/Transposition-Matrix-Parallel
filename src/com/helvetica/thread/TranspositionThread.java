package com.helvetica.thread;

public class TranspositionThread extends Thread{

    private final int [][] originalMatrix;
    private final int [][] matrixToTransposition;
    private final int threadNumber;
    private final int rowPerThread;
    private final int threadRowSize;

    @Override
    public void run() {
        for (int col = 0; col < originalMatrix.length; col++) {
            for(int row = 0; row < rowPerThread; row++) {
                int currentRow = threadNumber * threadRowSize + row;
                matrixToTransposition[currentRow][col] = originalMatrix[col][currentRow];
            }
        }
    }

    public TranspositionThread(int [][] originalMatrix,
                               int [][] matrixToTransposition,
                               int threadNumber,
                               int rowPerThread,
                               int threadRowSize) {
        this.originalMatrix = originalMatrix;
        this.matrixToTransposition = matrixToTransposition;
        this.threadNumber = threadNumber;
        this.rowPerThread = rowPerThread;
        this.threadRowSize = threadRowSize;
    }

    public int[][] getMatrixToTransposition() {
        return matrixToTransposition;
    }

    public int getRowPerThread() {
        return rowPerThread;
    }
}
