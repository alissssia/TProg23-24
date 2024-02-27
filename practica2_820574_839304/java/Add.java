/*
* Fichero: Add.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

// Clase heredada de Instruccion
public class Add extends Instruccion{
    // Constructor: inicializa el nombre de la instruccion
    Add(){
        nombre = "add";     
    }

    // Metodo: Extrae los dos primeros elementos de la pila, inserta su suma y aumenta el pc en 1
    public void ejecutar(Stack<Integer> pila, int[] pc){
        int a, b;
        a = pila.pop();
        b = pila.pop();     // Saca los dos elementos de la pila

        pila.push(a + b);   // Apila la suma
        pc[0]++;            // Aumenta en 1 el pc
    }
}
