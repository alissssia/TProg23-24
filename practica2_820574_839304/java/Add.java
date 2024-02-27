/*
* Fichero: Add.java
* Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

public class Add extends Instruccion{
    Add(){
        nombre = "add"; // inicializa el nombre de la instrucción
    }
    public void ejecutar(Stack<Integer> pila, int[] pc){
        int a, b;
        a = pila.pop();
        b = pila.pop(); // saca los dos elementos de la pila

        pila.push(a + b); // apila la suma
        pc[0]++;
    }
}
