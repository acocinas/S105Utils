package com.library.level1.exercise5.controller;

import com.library.level1.exercise5.entities.Person;

import java.io.*;

public class SerializationExample {
    public static void run() {
        Person person = new Person("Pepe", 40);

        String filePath = "person.ser";

        serializePerson(person, filePath);

        if (fileExists(filePath)) {
            Person deserializedPerson = deserializePerson(filePath);
            if (deserializedPerson.getName().equals("desconocido")) {
                System.out.println("No se pudo deserializar el objeto");
            } else {
                System.out.println("Deserializando: " + deserializedPerson);
            }
        } else {
            System.out.println("El archivo '" + filePath + "' no existe. No se puede deserializar");
        }
    }

    private static String normalizePath(String path) {
        return path.replace("/", File.separator).replace("\\", File.separator);
    }

    private static boolean fileExists(String filePath) {
        filePath = normalizePath(filePath);
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }

    private static void serializePerson(Person person, String filePath) {
        filePath = normalizePath(filePath);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(person);
            System.out.println("El objeto Persona 'Person' se ha serializado al archivo '" + filePath + "'");
        } catch (IOException e) {
            System.out.println("Error durante la serialización: " + e.getMessage());
        }
    }

    private static Person deserializePerson(String filePath) {
        filePath = normalizePath(filePath);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Person) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error durante la deserialización: " + e.getMessage());
            return new Person("desconocido", -1);
        }
    }
}

