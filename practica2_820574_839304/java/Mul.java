/*
* Fichero: Mul.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

// Clase heredada de Instruccion
public class Mul extends Instruccion{
    // Constructor: inicializa el nombre de la instruccion
    Mul(){
        this.nombre = "mul";
    }

    // Metodo: Extrae los dos primeros elementos de la pila, 
    //          inserta su producto y aumenta en 1 el pc
    public void ejecutar(Stack<Integer> pila, int[] pc){
        int a, b;
        a = pila.pop();
        b = pila.pop();

        pila.push(a * b);
        pc[0]++;
    }
}