package com.library.level1.exercise2;

import java.io.File;
import java.util.Arrays;
import java.text.SimpleDateFormat;


public class DirectoryTreeLister {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DirectoryTreeLister <directory_path>");
            return;
        }

        File directory = new File(args[0]);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
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
                System.out.println((file.isDirectory() ? "D" : "F") + " - " + file.getName() + " - Last Modified: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
                if (file.isDirectory()) {
                    listDirectory(file, level + 1);
                }
            }
        }
    }

}
