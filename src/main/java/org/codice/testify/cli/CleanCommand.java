package org.codice.testify.cli;

import io.airlift.airline.Command;

@Command(name = "clean", description = "Clean up test runs")
public class CleanCommand extends TestifyCommand {

    public void run() {
        System.out.println("@|blue Cleaning up Test Results|@");
    }
}
