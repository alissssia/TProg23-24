/*
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 06/03/2024
*/

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        ConjuntoAnagramas anagramas  = new ConjuntoAnagramas();

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la direccion de un diccionario: ");
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingresa la dirección del archivo de texto:");
        String direccionArchivo = scanner.nextLine();

        try{
            File archivo = new File(direccionArchivo);
            Scanner lectorArchivo = new Scanner(archivo);

            System.out.println("Contenido del archivo:");

            // Leer palabras del archivo mientras haya más
            while (lectorArchivo.hasNext()) {
                String palabra = lectorArchivo.next();
                anagramas.anadirAnagrama(palabra);
            }

            lectorArchivo.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo: " + e.getMessage());
        }
    }
}