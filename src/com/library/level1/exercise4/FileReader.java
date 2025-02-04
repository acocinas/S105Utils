package com.library.level1.exercise4;

import java.io.*;

public class FileReader {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileReader <file_path>");
            return;
        }

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
