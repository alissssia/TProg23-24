/*
* Fichero: Main.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

// Clase principal
// Lista y ejecuta los 3 programas implementados, uno seguido de otro
public class Main {
    public static void main(String[] args) {
        
        Prog_suma p1 = new Prog_suma();
        Prog_cuenta_atras p2 = new Prog_cuenta_atras();
        Prog_factorial p3 = new Prog_factorial();

        p1.listar();
        p1.run();
        System.out.println("\n");

        p2.listar();
        p2.run();
        System.out.println("\n");


        p3.listar();
        p3.run();
    }
}

