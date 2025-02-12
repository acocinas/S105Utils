
# Nivel 1 - Ejercicios

Para estos ejercicios se ha usado el IDE IntelliJ configurado con la versión Jbr 17 de Java.
En cada uno de los ejercicios se especifica los comandos que se deben usar por consola, en caso de compilar y ejecutar
fuera de los IDE de IntelliJ o Eclipse.

Usar -d ruta de directorio en la compilación y -cp ruta de directorio en la ejecución es para indicar las rutas
donde guardar y donde buscar los .class y así evitar errores.
Estos comandos se deben ejecutar desde la raíz del proyecto. Para cualquier duda en las rutas, al final de este
readme.txt está el árbol del proyecto, que facilita seguir las rutas correctas tanto para compilar como ejecutar.

## Ejercicio 1: Listar contenido de un directorio
1. Compilar todos los package del ejercicio 1 a la vez:
   javac -d out/production/S105Utils src/com/library/level1/exercise1/**/*.java
2. Ejecutar:
   java -cp out/production/S105Utils com.library.level1.exercise1.Main     ruta_del_directorio(Opcional*)
  *Opcional, puesto que si no se pone al ejecutar, se pedirá hasta dar una ruta correcta. por ejemplo (./out)(src)

## Ejercicio 2: Listar árbol de directorios
1. Compilar:
   javac -d out/production/S105Utils src/com/library/level1/exercise2/**/*.java
2. Ejecutar:
   java -cp out/production/S105Utils com.library.level1.exercise2.Main ruta_del_directorio

## Ejercicio 3: Guardar árbol de directorios en un fichero TXT
1. Compilar:
   javac -d out/production/S105Utils src/com/library/level1/exercise3/DirectoryTreeToFile.java
2. Ejecutar:
   java -cp out/production/S105Utils com.library.level1.exercise3.DirectoryTreeToFile ruta_del_directorio ruta_del_fichero_salida.txt

## Ejercicio 4: Leer y mostrar contenido de un fichero TXT
1. Compilar:
   javac -d out/production/S105Utils src/com/library/level1/exercise4/FileReader.java
2. Ejecutar:
   java -cp out/production/S105Utils com.library.level1.exercise4.FileReader ruta_del_fichero.txt

## Ejercicio 5: Serializar y deserializar un objeto
1. Compilar:
   javac -d out/production/S105Utils src/com/library/level1/exercise5/Controller/SerializationExample.java src/com/library/level1/exercise5/Entities/Person.java
2. Ejecutar:
   java -cp out/production/S105Utils com.library.level1.exercise5.Controller.SerializationExample

S105Utils
├── S105Utils.iml
├── out
│   └── production
│       └── S105Utils
│           └── com
│               └── library
│                   └── level1
│                       ├── exercise1
│                       │   └── DirectoryLister.class
│                       ├── exercise2
│                       │   └── DirectoryTreeLister.class
│                       ├── exercise3
│                       │   └── DirectoryTreeToFile.class
│                       ├── exercise4
│                       │   └── FileReader.class
│                       └── exercise5
│                           ├── Controller
│                           │   └── SerializationExample.class
│                           ├── Entities
│                           │   └── Person.class
│                           └── Main.class
├── output.txt
├── person.ser
└── src
    ├── com
    │   └── library
    │       └── level1
    │           ├── exercise1
    │           │   ├── DirectoryLister.class
    │           │   └── DirectoryLister.java
    │           ├── exercise2
    │           │   ├── DirectoryTreeLister.class
    │           │   └── DirectoryTreeLister.java
    │           ├── exercise3
    │           │   ├── DirectoryTreeToFile.class
    │           │   └── DirectoryTreeToFile.java
    │           ├── exercise4
    │           │   └── FileReader.java
    │           └── exercise5
    │               ├── Controller
    │               │   └── SerializationExample.java
    │               ├── Entities
    │               │   └── Person.java
    │               └── Main.java
    └── readme.txt
