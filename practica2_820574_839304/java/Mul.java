/*
* Fichero: Mul.java
* Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

public class Mul extends Instruccion{
    Mul(){
        this.nombre = "mul";
    }
    public void ejecutar(Stack<Integer> pila, int[] pc){
        int a, b;
        a = pila.pop();
        b = pila.pop();

        pila.push(a * b);
        pc[0]++;
    }
}