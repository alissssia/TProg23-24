/*
* Fichero: Instruccion.java
* Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;
/*
* Clase abstracta instruccion. Define el atributo nombre que tendran todas las herederas, ademas del constructor
* y el metodo abstracto ejecutar que deberan implementar todas las clases que hereden de esta. Tambien se define
* el metodo nombrar que devuelve el nombre de la instruccion y que no cambiara para las clases herederas.
*/
abstract class Instruccion {
    protected String nombre;
    Instruccion(){}
    abstract void ejecutar(Stack<Integer> pila, int[] pc);
    String nombrar() {
        return nombre;
    }
}