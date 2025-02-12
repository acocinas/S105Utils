package com.library.level1.exercise1;

import com.library.level1.exercise1.controller.DirectoryLister;

public class Main {
    public static void main(String[] args){
        String path = (args.length > 0) ? args[0] : null;
        DirectoryLister.run(path);
    }
}
