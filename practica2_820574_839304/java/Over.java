/*
* Fichero: Over.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

// Clase heredada de Instruccion
public class Over extends Instruccion{

    // Constructor: inicializa el nombre de la instruccion
    Over(){
        nombre = "over";
    }

    // Metodo: Extrae los dos primeros elementos de la pila, los vuelve a insertar en el
    //         mismo orden e inserta otra vez el segundo extraido, y aumenta en 1 el pc
    public void ejecutar(Stack<Integer> pila, int[] pc){
        int a, b;
        a = pila.pop();
        b = pila.pop();

        pila.push(b);
        pila.push(a);
        pila.push(b);
        pc[0]++;
    }
}