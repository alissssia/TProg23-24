/*
* Fichero: Over.java
* Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

public class Over extends Instruccion{
    Over(){
        nombre = "over";
    }
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