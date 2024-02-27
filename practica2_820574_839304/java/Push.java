/*
* Fichero: Push.java
* Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

public class Push extends Instruccion{
    private int valor;
    Push(int num){
        nombre = "push";
        valor = num;
    }
    public void ejecutar(Stack<Integer> pila, int[] pc){
        pila.push(valor);
        pc[0]++;
    }
}