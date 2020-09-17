package com.helvetica.examples;

import com.helvetica.services.MatrixGeneratorService;
import com.helvetica.services.PrintService;
import com.helvetica.services.TranspositionService;
import com.helvetica.services.ThreadTranspositionService;

public class ImprovementExampleCommand {

    public static final String ELEMENTS_NUMBER = "Elements number: ";
    public static final String ORIGINAL_MATRIX = "Original Matrix:";
    public static final String TRANSPOSED_SERIAL = "Transposed Serial:";
    public static final String TRANSPOSED_PARALLEL = "Transposed Parallel:";
    private final int numThreads;
    private final int dimension;

    public void execute() throws InterruptedException {
        TranspositionService transpositionService = new TranspositionService();
        ThreadTranspositionService threadTranspositionService =
                new ThreadTranspositionService(MatrixGeneratorService.generateEmpty(dimension));

        int [][] matrix = MatrixGeneratorService.generate(dimension);
        int [][] resultSerial;

        PrintService.print(ELEMENTS_NUMBER + dimension * dimension);
        PrintService.print(ORIGINAL_MATRIX);
        PrintService.printMatrix(matrix);
        PrintService.printBlank();

        long t1 = System.currentTimeMillis();
        resultSerial = transpositionService.getTransposed(matrix);
        long t11 = System.currentTimeMillis() - t1;

        PrintService.print(TRANSPOSED_SERIAL);
        PrintService.printMatrix(resultSerial);
        PrintService.printFinished(t11);
        PrintService.printBlank();

        PrintService.printThreads(numThreads);
        long t2 = System.currentTimeMillis();
        threadTranspositionService.transpositionParallel(numThreads, matrix);
        long t21 = System.currentTimeMillis() - t2;

        PrintService.print(TRANSPOSED_PARALLEL);
        PrintService.printMatrix(threadTranspositionService.getTransposedMatrix());
        PrintService.printFinished(t21);

        double improvement = (double) t11 / t21;
        double efficiency = improvement / numThreads;
        PrintService.printImprovement(improvement);
        PrintService.printEfficiency(efficiency);

    }

    public ImprovementExampleCommand(int numThreads, int dimension) {
        this.numThreads = numThreads;
        this.dimension = dimension;
    }
}
