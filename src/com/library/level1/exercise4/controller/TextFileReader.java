package com.library.level1.exercise4.controller;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class TextFileReader {
    public static void run(String path) {
        Scanner sc = new Scanner(System.in);
        while (path == null || path.isBlank() || !isValidFile(path)) {
            System.out.println("Introduce el <file_path>");
            path = sc.nextLine();
            path = path.replace("/", File.separator).replace("\\", File.separator);;
        }
        readFile(path);
        sc.close();
    }

    private static boolean isValidFile(String path) {
        Path filePath = Paths.get(path);
        return Files.exists(filePath) && Files.isRegularFile(filePath);
    }

    private static void readFile(String path) {
        Path filePath = Paths.get(path);

        try (Stream<String> lines = Files.lines(filePath)) {
            Iterator<String> iterator = lines.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (AccessDeniedException e) {
            System.err.println("No hay permisos para leer ese archivo");
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo. Verifica que no esté dañado o en uso");
        }
    }

}

