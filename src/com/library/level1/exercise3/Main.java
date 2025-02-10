package com.library.level1.exercise3;

import com.library.level1.exercise3.controller.DirectoryTreeToFile;

public class Main {
    public static void main(String[] args){
        String path = (args.length > 0) ? args[0] : null;
        DirectoryTreeToFile.run(path);
    }
}

