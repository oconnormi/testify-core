package org.codice.testify.cli;

import io.airlift.airline.Option;
import io.airlift.airline.OptionType;
import org.codice.testify.engine.ProjectLoader;
import org.codice.testify.objects.AllObjects;
import org.codice.testify.objects.Project;
import org.codice.testify.objects.TestifyLogger;

import java.io.File;
import java.util.List;
import java.util.Map;

public class TestifyCommand implements Runnable
{
    @Option(type = OptionType.GLOBAL, name = {"-v", "--verbose"}, description = "Verbose mode")
    public boolean verbose = false;

    @Option(type =  OptionType.GLOBAL, name = {"-p", "--property"}, description = "Property Overrides")
    public List<String> properties;

    @Option(type = OptionType.GLOBAL, name = {"-r", "--results"}, arity = 1, description = "Alternate results directory")
    public String resultsDir = null;

    @Option(type = OptionType.GLOBAL, name = {"-c", "--config"}, arity = 1, description = "Alternate Configuration file or directory")
    public String configFile = null;

    @Option(type = OptionType.GLOBAL, name = {"-l", "--log-level"}, arity = 1, allowedValues = {"TRACE", "DEBUG", "INFO", "WARN", "ERROR", "FATAL"}, description = "Log Level")
    public String logLevel = "INFO";

    @Option(type = OptionType.GLOBAL, name = {"-f", "--testify-file"}, arity = 1, description = "Path to alternate .testify.yml file")
    public String directory = System.getProperty("user.dir");

    public void run()
    {
        TestifyLogger.setVerbose(verbose);
        // Load Project
        new ProjectLoader(new File(directory));
        Project project = (Project) AllObjects.getObject("testify.project");

        System.out.println("@|blue Loading project:|@ @|orange" + project.getProjectName() + "|@");
    }
}