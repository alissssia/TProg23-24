/*
* Fichero: Swap.java
* Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

public class Swap extends Instruccion{
    Swap(){
        nombre = "swap";
    }
    public void ejecutar(Stack<Integer> pila, int[] pc){
        int a, b;
        a = pila.pop();
        b = pila.pop();
        pila.push(a);
        pila.push(b);
        pc[0]++;
    }
}