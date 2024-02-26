package practica2_820574_839304.java;

import practica2_820574_839304.java.Instruccion;
import practica2_820574_839304.java.Pila_ints;

public class Jump_If extends Instruccion{
    private int valor;
    Jump_If(int num){
        nombre = "jump_if";
        valor = num;
    }
    public void ejecutar(Pila_ints pila, int[] pc){
        int a = pila.extraer();
        if (a >= 0) {
            pc[0] = valor;
        } else {
            pc[0]++;
        }
    }
}