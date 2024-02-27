/*
* Fichero: Dup.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

// Clase heredada de Instruccion
public class Dup extends Instruccion{
    // Constructor: inicializa el nombre de la instruccion
    Dup(){
        nombre = "dup";
    }
    
    // Metodo: Extrae el primer elemento de la pila, lo inserta dos veces y aumenta el pc en 1
    public void ejecutar(Stack<Integer> pila, int[] pc){
        int a;
        a = pila.pop(); // Se saca el valor de la cima de la pila
        pila.push(a);
        pila.push(a);   // Se duplica el valor de la cima de la pila
        pc[0]++;
    }
}