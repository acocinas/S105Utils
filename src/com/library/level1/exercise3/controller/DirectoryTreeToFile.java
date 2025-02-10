package com.library.level1.exercise3.controller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class DirectoryTreeToFile {
    public static void run(String path) {
        Scanner sc = new Scanner(System.in);
        if (path == null || path.isBlank()){
            System.out.println("Introduce el directorio path: ");
            path = sc.nextLine();
        }
        sc.close();

        path = path.replace("/", File.separator).replace("\\", File.separator);

        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            System.exit(1);
        }

        File outputFile = new File(directory, "output.txt");

        try (FileWriter writer = new FileWriter(outputFile)) {
            listDirectory(directory, 0, writer);
            System.out.println("Directory tree saved to " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void listDirectory(File directory, int level, FileWriter writer) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.sort(files);
            for (File file : files) {
                for (int i = 0; i < level; i++) {
                    writer.write("  ");
                }
                writer.write((file.isDirectory() ? "D" : "F") + " - " + file.getName() + " - Last Modified: " +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()) + "\n");
                if (file.isDirectory()) {
                    listDirectory(file, level + 1, writer);
                }
            }
        }

    }
}
