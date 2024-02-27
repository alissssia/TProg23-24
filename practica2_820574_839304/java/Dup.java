/*
* Fichero: Dup.java
* Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

public class Dup extends Instruccion{
    Dup(){
        nombre = "dup";
    }
    public void ejecutar(Stack<Integer> pila, int[] pc){
        int a;
        a = pila.pop(); // Se saca el valor de la cima de la pila
        pila.push(a);
        pila.push(a); // Se duplica el valor de la cima de la pila
        pc[0]++;
    }
}