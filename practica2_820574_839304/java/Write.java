/*
* Fichero: Write.java
* Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

public class Write extends Instruccion{
    Write(){
        nombre = "write";
    }
    public void ejecutar(Stack<Integer> pila, int[] pc){
        int a;
        a = pila.pop();
        System.out.print(a);
        System.out.println();
        pc[0]++;
    }
}
