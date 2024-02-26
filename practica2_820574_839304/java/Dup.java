package practica2_820574_839304.java;

import practica2_820574_839304.java.Instruccion;
import practica2_820574_839304.java.Pila_ints;

public class Dup extends Instruccion{
    Dup(){
        nombre = "dup";
    }
    public void ejecutar(Pila_ints pila, int[] pc){
        int a;
        a = pila.extraer();
        pila.insertar(a);
        pila.insertar(a);
        pc[0]++;
    }
}