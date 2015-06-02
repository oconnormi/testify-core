package org.codice.testify.cli.run;

import io.airlift.airline.Arguments;
import io.airlift.airline.Command;
import org.codice.testify.cli.TestifyCommand;
import org.codice.testify.engine.TestEngine;
import org.codice.testify.objects.TestifyLogger;

import static org.fusesource.jansi.Ansi.ansi;

@Command(name = "all", description = "Run entire project")
public class RunAllCommand extends TestifyCommand {
    @Arguments(description = "Directory to run, defaults to working directory")
    public String directory = System.getProperty("user.dir");

    @Override
    public void run() {

        TestEngine dtr = new TestEngine();
        TestifyLogger.setVerbose(verbose);
        System.out.println( ansi().eraseScreen().render("@|blue Building Docket|@"));
        dtr.testifyRunner(directory, properties, resultsDir, configFile, logLevel);
    }
}
