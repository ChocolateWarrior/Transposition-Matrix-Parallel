package com.helvetica;

import com.helvetica.examples.ImprovementExampleCommand;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ImprovementExampleCommand commandSmall = new ImprovementExampleCommand(8, 100);
        ImprovementExampleCommand commandAverage = new ImprovementExampleCommand(8, 1000);
        ImprovementExampleCommand commandBig = new ImprovementExampleCommand(8, 10000);
        commandSmall.execute();
        commandAverage.execute();
        commandBig.execute();
    }
}
