package practica2_820574_839304.java;
import practica2_820574_839304.java.Prog_factorial;
import practica2_820574_839304.java.Prog_cuenta_atras;
import practica2_820574_839304.java.Prog_suma;



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
        System.out.println("\n");
    }
}