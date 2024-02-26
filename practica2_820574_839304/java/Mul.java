package practica2_820574_839304.java;

import practica2_820574_839304.java.Instruccion;
import practica2_820574_839304.java.Pila_ints;

public class Mul extends Instruccion{
    Mul(){
        this.nombre = "mul";
    }
    public void ejecutar(Pila_ints pila, int[] pc){
        int a, b;
        a = pila.extraer();
        b = pila.extraer();

        pila.insertar(a * b);
        pc[0]++;
    }
}