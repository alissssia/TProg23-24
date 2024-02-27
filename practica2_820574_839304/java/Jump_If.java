/*
* Fichero: Jump_if.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

// Clase heredada de Instruccion
public class Jump_If extends Instruccion{
    // Atributos
    private int valor;

    // Constructor: el numero pasado por parametro sera guardado en el atributo 'valor'
    Jump_If(int num){
        nombre = "jump_if";
        valor = num;
    }

    // Metodo: extrae el primer elemento de la pila
    //      si es mayor o igual que cero, modifica el pc igual que "valor"
    //      si es menor que cero, aumenta el pc en 1
    public void ejecutar(Stack<Integer> pila, int[] pc){
        int a = pila.pop();
        if (a >= 0) {
            pc[0] = valor;
        } else {
            pc[0]++;
        }
    }
}