package com.library.level1.exercise2.controller;

import java.io.File;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DirectoryTreeLister {
    public static void run(String path) {
        Scanner sc = new Scanner(System.in);
        if (path == null || path.isBlank()){
            System.out.println("Introduce el directorio path: ");
            path = sc.nextLine();
            sc.close();
        }

        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            System.exit(1);
        }
        listDirectory(directory, 0);
    }

    private static void listDirectory(File directory, int level) {
        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.sort(files);
            for (File file : files) {
                for (int i = 0; i < level; i++) {
                    System.out.print("  ");
                }
                System.out.println((file.isDirectory() ? "D" : "F") +
                        " - " + file.getName() + " - Last Modified: " +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
                if (file.isDirectory()) {
                    listDirectory(file, level + 1);
                }
            }
        }
    }
}
