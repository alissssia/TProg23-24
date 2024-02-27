/*
* Fichero: Main.java
* Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
* Fecha: 27/02/2023
*/


public class Main {
    public static void main(String[] args) {
        
        Prog_suma p1 = new Prog_suma();
        Prog_cuenta_atras p2 = new Prog_cuenta_atras();
        Prog_factorial p3 = new Prog_factorial();

        System.out.println("Programa:\n");        
        p1.listar();
        System.out.println("Ejecución:\n");
        p1.run();
        System.out.println("\n");


        System.out.println("Programa:\n");
        p2.listar();
        System.out.println("Ejecución:\n");
        p2.run();
        System.out.println("\n");


        System.out.println("Programa:\n");
        p3.listar();
        System.out.println("Ejecución:\n");
        p3.run();
        //System.out.println("\n");
    }
}

