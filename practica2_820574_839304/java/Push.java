package practica2_820574_839304.java;

import practica2_820574_839304.java.Instruccion;
import practica2_820574_839304.java.Pila_ints;

public class Push extends Instruccion{
    private int valor;
    Push(int num){
        nombre = "push";
        valor = num;
    }
    public void ejecutar(Pila_ints pila, int[] pc){
        pila.insertar(valor);
        pc[0]++;
    }
}