package practica2_820574_839304.java;

import practica2_820574_839304.java.Instruccion;
import practica2_820574_839304.java.Pila_ints;

public class Add extends Instruccion{
    Add(){
        nombre = "add";
    }
    public void ejecutar(Pila_ints pila, int[] pc){
        int a, b;
        a = pila.extraer();
        b = pila.extraer();

        pila.insertar(a + b);
        pc[0]++;
    }
}
