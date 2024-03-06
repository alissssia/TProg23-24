/*
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 06/03/2024
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ConjuntoAnagramas anagramas  = new ConjuntoAnagramas();

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la direccion de un diccionario: ");
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingresa la dirección del archivo de texto:");
        String direccionArchivo = scanner.nextLine();

        System.out.println("Por favor, ingresa el numero minimo de palabras:");
        int tamanoMinimo = Integer.parseInt(scanner.nextLine());

        try{
            File archivo = new File(direccionArchivo);
            Scanner lectorArchivo = new Scanner(archivo);

            // Leer palabras del archivo mientras haya más
            while (lectorArchivo.hasNext()) {
                String palabra = lectorArchivo.next();
                anagramas.anadirAnagrama(palabra);
            }
            
            lectorArchivo.close();
            System.out.println();

            String resultado = anagramas.toString(tamanoMinimo);
            if (resultado == ""){
                System.out.println("No se han encontrado anagramas con un mínimo de " + tamanoMinimo + " palabras.");
            } else {
                System.out.println(">> ANAGRAMAS ENCONTRADOS:");
                System.out.println(anagramas.toString(tamanoMinimo));
            }
            

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo: " + e.getMessage());
        }
    }
}