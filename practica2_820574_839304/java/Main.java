package practica2_820574_839304.java;

import practica2_820574_839304.java.Prog_suma;
import practica2_820574_839304.java.Prog_cuenta_atras;
import practica2_820574_839304.java.Prog_factorial;

public class Main {
    public static void main(String[] args) {
        Prog_factorial p1 = new Prog_factorial();
        Prog_cuenta_atras p2 = new Prog_cuenta_atras();
        Prog_suma p3 = new Prog_suma();

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