package com.library.level1.exercise5.Controller;

import com.library.level1.exercise5.Entities.Person;

import java.io.*;

public class SerializationExample {
    public static void run(){
        Person person = new Person("Pepe" , 40);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))){
            oos.writeObject(person);
            System.out.println("Person object serialized to person.ser");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))){
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Deserialized Person: "+ deserializedPerson);
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error during deserialization: " + e.getMessage());
        }

    }
}
