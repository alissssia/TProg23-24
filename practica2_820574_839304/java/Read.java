/*
* Fichero: Read.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Scanner;
import java.util.Stack;

public class Read extends Instruccion {
    // Constructor: inicializa el nombre de la instruccion
    Read(){
        nombre = "read";
    }

    // Metodo: pide por pantalla que el usuario introduzca un valor y aumenta en 1 el pc
    public void ejecutar(Stack<Integer> pila, int[] pc){
        Scanner scanner = new Scanner(System.in);
        int a;
        System.out.print("? ");
        a = scanner.nextInt();
        pila.push(a);
        pc[0]++;
    }
}
