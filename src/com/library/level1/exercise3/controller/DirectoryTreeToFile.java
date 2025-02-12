package com.library.level1.exercise3.controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class DirectoryTreeToFile {
    public static void run(String path) {
        Scanner sc = new Scanner(System.in);
        while (path == null || path.isBlank() || !isValidDirectory(path)) {
            System.out.println("Introduce el directorio path(carpeta donde guardar el txt): ");
            path = sc.nextLine();
            path = path.replace("/", File.separator).replace("\\", File.separator);
        }
        sc.close();

        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directorio no válido.");
            System.exit(1);
        }

        File outputFile = new File(directory, "output.txt");

        try (FileWriter writer = new FileWriter(outputFile)) {
            listDirectory(directory, 0, writer);
            System.out.println("Directory tree saved to (la ruta del archivo es): " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error escribiendo el archivo: " + e.getMessage());
        }
    }

    private static boolean isValidDirectory(String path){
        Path directoryPath = Paths.get(path);
        return Files.exists(directoryPath);
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
