/*
 * Copyright 2015 Codice Foundation
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.codice.testify;

import org.codice.testify.engine.TestEngine;

import io.airlift.airline.*;
import io.airlift.airline.help.Help;
import org.codice.testify.objects.TestifyLogger;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

import java.io.File;
import java.util.List;

/**
 * The Main class takes in user provided arguments and starts the Testify TestEngine
 */
public class Testify {

    /**
     * The main method is the starting point for the Testify jar file. It sets up the cli and hands execution
     * off to the correct components.
     * @param args the arguments provided by the user at runtime
     */
    public static void main(String[] args) {

        AnsiConsole.systemInstall();

        Cli.CliBuilder<Runnable> builder = Cli.<Runnable>builder("testify")
                .withDescription("an integration test framework")
                .withDefaultCommand(Help.class)
                .withCommands(Help.class, Clean.class);

        builder.withGroup("run")
                .withDescription("run tests")
                .withDefaultCommand(Run.class);

        Cli<Runnable> testifyParser = builder.build();

        testifyParser.parse(args).run();

//        //Set the TestEngine parameters from the user provided arguments
//        String testDir = args[0];
//        String resultDir = args[1];
//        String configFile = args[2];
//        String logLevel = args[3];
//
//        //Run the DTF TestEngine
//        TestEngine dtr = new TestEngine();
//        dtr.testifyRunner(testDir, resultDir, configFile, logLevel);
//        System.exit(0);
    }

    public static class TestifyCommand implements Runnable
    {

        @Option(type = OptionType.GLOBAL, name = {"-v", "--verbose"}, description = "Verbose mode")
        public boolean verbose = false;

        @Option(type =  OptionType.GLOBAL, name = {"-p", "--property"}, description = "Property")
        public List<String> properties;

        @Option(type = OptionType.GLOBAL, name = {"-r", "--results"}, arity = 1, description = "Results Directory [default: $PWD/results]")
        public String resultsDir = System.getProperty("user.dir") + System.lineSeparator() + "results";

        @Option(type = OptionType.GLOBAL, name = {"-c", "--config"}, arity = 1, description = "Config file or directory [default: $PWD/properties")
        public String configFile = System.getProperty(("user.dir") + System.lineSeparator() + "properties");

        @Option(type = OptionType.GLOBAL, name = {"-l", "--log-level"}, arity = 1, allowedValues = {"TRACE", "DEBUG", "INFO", "WARN", "ERROR", "FATAL"}, description = "Log Level")
        public String logLevel = "INFO";

        public void run()
        {
            TestifyLogger.setVerbose(verbose);
            System.out.println(getClass().getSimpleName());
        }
    }

    @Command(name = "run", description = "Run Testify tests")
    public static class Run extends TestifyCommand {
        @Arguments(description = "Directory to run, defaults to working directory")
        public String directory = System.getProperty("user.dir");

        @Override
        public void run() {

            TestEngine dtr = new TestEngine();
            TestifyLogger.setVerbose(verbose);
            System.out.println( ansi().eraseScreen().render("@|blue Building Docket|@"));
            dtr.testifyRunner(directory, resultsDir, configFile, logLevel);
        }
    }

    @Command(name = "clean", description = "Clean up test runs")
    public static class Clean extends TestifyCommand {

    }
}