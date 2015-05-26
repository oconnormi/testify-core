package org.codice.testify.objects;

import java.io.File;

public class Project {

    public File PROJECT_ROOT;

    public String RESULTS_DIRECTORY;

    public String PREP_DIRECTORY;

    public String DATA_DIRECTORY;

    public String TEST_DIRECTORY;

    public String PROPERTIES_DIRECTORY;

    public Project() {
    }

    public File getProjectRoot() {
        return PROJECT_ROOT;
    }

    public void setProjectRoot(File projectRoot) {
        PROJECT_ROOT = projectRoot;
    }

    public String getResultsDirectory() {
        return RESULTS_DIRECTORY;
    }

    public void setResultsDirectory(String resultsDirectory) {
        RESULTS_DIRECTORY = resultsDirectory;
    }

    public String getPrepDirectory() {
        return PREP_DIRECTORY;
    }

    public void setPrepDirectory(String prepDirectory) {
        PREP_DIRECTORY = prepDirectory;
    }

    public String getDataDirectory() {
        return DATA_DIRECTORY;
    }

    public void setDataDirectory(String dataDirectory) {
        DATA_DIRECTORY = dataDirectory;
    }

    public String getTestDirectory() {
        return TEST_DIRECTORY;
    }

    public void setTestDirectory(String testDirectory) {
        TEST_DIRECTORY = testDirectory;
    }

    public String getPropertiesDirectory() {
        return PROPERTIES_DIRECTORY;
    }

    public void setPropertiesDirectory(String propertiesDirectory) {
        PROPERTIES_DIRECTORY = propertiesDirectory;
    }
}

