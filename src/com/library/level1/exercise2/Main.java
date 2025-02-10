package com.library.level1.exercise2;

import com.library.level1.exercise2.controller.DirectoryTreeLister;

public class Main {
    public static void main(String[] args){
        String path = (args.length > 0) ? args[0] : null;
        DirectoryTreeLister.run(path);
    }
}
