package com.epam.automation.inputoutput.maintask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Directory {
    List<String> files = new ArrayList<>();

    public void addFile(String file){
        files.add(file);
    }
}
