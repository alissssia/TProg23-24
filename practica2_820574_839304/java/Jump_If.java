/*
* Fichero: Jump_if.java
* Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

public class Jump_If extends Instruccion{
    private int valor;
    Jump_If(int num){
        nombre = "jump_if";
        valor = num;
    }
    public void ejecutar(Stack<Integer> pila, int[] pc){
        int a = pila.pop();
        if (a >= 0) {
            pc[0] = valor;
        } else {
            pc[0]++;
        }
    }
}