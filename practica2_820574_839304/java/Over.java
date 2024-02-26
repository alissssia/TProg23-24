package practica2_820574_839304.java;

import practica2_820574_839304.java.Instruccion;
import practica2_820574_839304.java.Pila_ints;

public class Over extends Instruccion{
    Over(){
        nombre = "over";
    }
    public void ejecutar(Pila_ints pila, int[] pc){
        int a, b;
        a = pila.extraer();
        b = pila.extraer();

        pila.insertar(b);
        pila.insertar(a);
        pila.insertar(b);
        pc[0]++;
    }
}