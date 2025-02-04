package com.library.level1.exercise3;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class DirectoryTreeToFile {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java DirectoryTreeToFile <directory_path> <output_file_path>");
            return;
        }

        File directory = new File(args[0]);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }
        try (FileWriter writer = new FileWriter(args[1])) {
            listDirectory(directory, 0, writer);
            System.out.println("Directory tree saved to " + args[1]);
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
                writer.write((file.isDirectory() ? "D" : "F") + " - " + file.getName() + " - Last Modified: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()) + "\n");
                if (file.isDirectory()) {
                    listDirectory(file, level + 1, writer);
                }
            }
        }

    }
}
