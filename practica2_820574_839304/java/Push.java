/*
* Fichero: Push.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

// Clase heredada de Instruccion
public class Push extends Instruccion{
    // Atributos
    private int valor;

    // Constructor: el numero pasado por parametro sera guardado en el atributo 'valor'
    Push(int num){
        nombre = "push";
        valor = num;
    }

    // Metodo: introduce 'valor' en la pila y aumenta en 1 el pc
    public void ejecutar(Stack<Integer> pila, int[] pc){
        pila.push(valor);
        pc[0]++;
    }
}