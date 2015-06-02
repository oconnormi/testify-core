package org.codice.testify.engine;

import org.codice.testify.objects.AllObjects;
import org.codice.testify.objects.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.io.File;

@RunWith(JUnit4.class)
public class ProjectLoaderTest {

    @Test
    public void testProjectDir() {
        File directory = new File(System.getProperty("user.dir") + "/src/test/resources/project");

        new ProjectLoader(directory);
        Project project = (Project)AllObjects.getObject("testify.project");
        assert(project.getProjectRoot().equals(directory));
    }

    @Test
    public void testSubDir() {
        File subDirectory = new File(System.getProperty("user.dir") + "/src/test/resources/project/sub1");
        File directory = new File(System.getProperty("user.dir") + "/src/test/resources/project");

        new ProjectLoader(subDirectory);
        Project project = (Project)AllObjects.getObject("testify.project");
        assert(project.getProjectRoot().equals(directory));
    }
}
