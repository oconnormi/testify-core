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

import org.codice.testify.cli.CleanCommand;
import org.codice.testify.cli.InitCommand;
import org.codice.testify.cli.create.CreateProjectCommand;
import org.codice.testify.cli.run.RunAllCommand;

import io.airlift.airline.*;
import io.airlift.airline.help.Help;
import org.fusesource.jansi.AnsiConsole;

import java.io.File;

/**
 * The Main class takes in user provided arguments and starts the Testify TestEngine
 */
public class Testify {

    private static File userDirectory = new File(System.getProperty("user.dir"));

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
                .withCommands(Help.class, CleanCommand.class, InitCommand.class);

        builder.withGroup("run")
                .withDescription("run tests")
                .withDefaultCommand(RunAllCommand.class);

        builder.withGroup("create")
                .withDescription("create projects and files")
                .withDefaultCommand(CreateProjectCommand.class);

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

}