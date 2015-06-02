package org.codice.testify.cli.create;

import io.airlift.airline.Arguments;
import io.airlift.airline.Command;
import org.codice.testify.cli.TestifyCommand;

@Command(name = "project", description = "Create a project")
public class CreateProjectCommand extends TestifyCommand {

    @Arguments(required = true, arity = 1, title = "Project Name", description = "Project name to create (will be used as the directory name also)")
    String name;

    @Override
    public void run() {
        System.out.println("@|blue Creating Project:|@ @|orange ");
    }
}
