package com.helvetica;

import com.helvetica.examples.ImprovementExampleCommand;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ImprovementExampleCommand commandSmall = new ImprovementExampleCommand(10);
        ImprovementExampleCommand commandAverage = new ImprovementExampleCommand(1000);
        ImprovementExampleCommand commandBig = new ImprovementExampleCommand(10000);
        commandSmall.execute();
        commandAverage.execute();
        commandBig.execute();
    }
}
