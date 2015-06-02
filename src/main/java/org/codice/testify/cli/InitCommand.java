package org.codice.testify.cli;

import io.airlift.airline.Command;

@Command(name = "init", description = "Initialize Project")
public class InitCommand extends TestifyCommand {
    public void run() {
        System.out.println("@|blue Initializing Project|@");
    }
}
