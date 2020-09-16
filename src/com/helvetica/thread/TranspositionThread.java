package com.helvetica.thread;

public class TranspositionThread extends Thread{

    private final int [][] originalMatrix;
    private final int [][] matrixToTransposition;
    private final int threadRow;

    public TranspositionThread(int [][] originalMatrix,
                               int [][] matrixToTransposition,
                               int threadRow) {
        this.originalMatrix = originalMatrix;
        this.matrixToTransposition = matrixToTransposition;
        this.threadRow = threadRow;
    }

    @Override
    public void run() {
        for (int i = 0; i < originalMatrix.length; i++) {
            matrixToTransposition [threadRow][i] = originalMatrix [i][threadRow];
        }
    }

    public int[][] getMatrixToTransposition() {
        return matrixToTransposition;
    }
}
