package com.example.db_spring_data_mvc_project.service;

import java.io.IOException;

public interface ProjectService {

    public static final String FILE_PATH = "files/xmls/projects.xml";

    boolean exists();

    String getXmlForImport() throws IOException;
}
