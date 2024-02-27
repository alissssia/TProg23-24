/*
* Fichero: Write.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

// Clase heredada de Instruccion
public class Write extends Instruccion{
    // Constructor: inicializa el nombre de la instruccion
    Write(){
        nombre = "write";
    }

    // Metodo: extrae y escribe por pantalla el primer elemento de la pila,
    //         y aumenta en 1 el pc
    public void ejecutar(Stack<Integer> pila, int[] pc){
        int a;
        a = pila.pop();
        System.out.print(a);
        System.out.println();
        pc[0]++;
    }
}
