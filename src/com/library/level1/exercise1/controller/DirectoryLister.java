package com.library.level1.exercise1.controller;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class DirectoryLister {
    public static void run (String path){
        Scanner sc = new Scanner(System.in);
        if (path == null || path.isBlank()){
            System.out.println("Introduce el directorio path: ");
            path = sc.nextLine().trim();
        }
        sc.close();
        
        path = path.replace("/", File.separator).replace("\\", File.separator);

        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()){
            System.out.println("Invalid directory path");
            System.exit(1);
        }

        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.sort(files);
            for (File file : files){
                System.out.println(file.getName());
            }
        }
    }
}
