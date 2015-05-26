package org.codice.testify.engine;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.codice.testify.objects.AllObjects;
import org.codice.testify.objects.Project;
import org.yaml.snakeyaml.Yaml;

public class ProjectLoader {

    private File projectRoot;
    private File projectFile;
    private boolean stopLooking = false;

    public ProjectLoader(File directory) {
        findProjectRoot(directory);
        loadProject();
    }

    private void findProjectRoot(File directory) {
        String directoryPath = directory.getAbsolutePath();
        String projectFilePath = directoryPath + File.separator + ".testify.yml";
        File projectFile = new File(projectFilePath);
        if (!stopLooking) {
            if (projectFile.exists() && projectFile.isFile()) {
                this.projectFile = projectFile;
                this.projectRoot = projectFile.getParentFile();
                stopLooking = true;
            }
            else {
                File parentFile = directory.getParentFile();
                if (parentFile.canRead() && parentFile.exists() && parentFile.isDirectory()) {
                    findProjectRoot(parentFile);
                }
                else {
                    stopLooking = true;
                }
            }
        }
    }

    public void loadProject() {
        Yaml yaml = new Yaml();
        Project project = new Project();

        try( InputStream in = Files.newInputStream( Paths.get( this.projectFile.getAbsolutePath() ) ) ) {
            project = yaml.loadAs( in, Project.class );
            project.setProjectRoot(this.projectRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AllObjects.setObject("testify.project", project);
    }

}
