package com.library.level1.exercise2.controller;

import java.io.File;
import java.nio.file.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class DirectoryTreeLister {
    public static void run(String path) {
        Scanner sc = new Scanner(System.in);
        while (path == null || path.isBlank() || !isValidFile(path)) {
            System.out.println("Introduce el directorio path: ");
            path = sc.nextLine();
            path = path.replace("/", File.separator).replace("\\", File.separator);
        }
        sc.close();

        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            System.exit(1);
        }
        listDirectory(directory, 0);
    }

    private static boolean isValidFile(String path){
        Path filePath = Paths.get(path);
        return Files.exists(filePath);
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
