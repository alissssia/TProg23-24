/*
* Fichero: Instruccion.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

/*
* Clase abstracta instruccion. Define el atributo nombre que tendran todas las herederas, ademas del constructor
* y el metodo abstracto ejecutar que deberan implementar todas las clases que hereden de esta. Tambien se define
* el metodo nombrar que devuelve el nombre de la instruccion y que no cambiara para las clases herederas.
*/
abstract class Instruccion {
    // Atributos
    protected String nombre;

    // Constructor
    Instruccion(){}

    // Metodo: abstracto, ejecuta las acciones necesarias sobre la pila o el pc
    abstract void ejecutar(Stack<Integer> pila, int[] pc);

    // Metodo: devuelve el valor del atributo "nombre"
    String nombrar() {
        return nombre;
    }
}