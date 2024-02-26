package practica2_820574_839304.java;

import practica2_820574_839304.java.Instruccion;
import practica2_820574_839304.java.Pila_ints;

public class Write extends Instruccion{
    Write(){
        nombre = "write";
    }
    public void ejecutar(Pila_ints pila, int[] pc){
        int a;
        a = pila.extraer();
        System.out.print(a);
        System.out.println();
        pc[0]++;
    }
}
