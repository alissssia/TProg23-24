package practica2_820574_839304.java;

import practica2_820574_839304.java.Instruccion;
import practica2_820574_839304.java.Pila_ints;
import java.util.Scanner;

public class Read extends Instruccion {
    Read(){
        nombre = "read";
    }
    public void ejecutar(Pila_ints pila, int[] pc){
        Scanner scanner = new Scanner(System.in);
        int a;
        System.out.print("? ");
        a = scanner.nextInt();
        pila.insertar(a);
        pc[0]++;
    }
}
