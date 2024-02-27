/*
* Fichero: Swap.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

public class Swap extends Instruccion{
    // Constructor: inicializa el nombre de la instruccion
    Swap(){
        nombre = "swap";
    }

    // Metodo: extrae los dos primeros elementos de la pila y los vuelve a introducir
    //         en orden inverso
    public void ejecutar(Stack<Integer> pila, int[] pc){
        int a, b;
        a = pila.pop();
        b = pila.pop();
        pila.push(a);
        pila.push(b);
        pc[0]++;
    }
}