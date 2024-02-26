package practica2_820574_839304.java;

import practica2_820574_839304.java.Pila_ints;

abstract class Instruccion {
    protected String nombre;
    Instruccion(){}
    abstract void ejecutar(Pila_ints pila, int[] pc);
    String nombrar() {
        return nombre;
    }
}