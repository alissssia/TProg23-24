/*
* Fichero: Read.java
* Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Scanner;
import java.util.Stack;

public class Read extends Instruccion {
    Read(){
        nombre = "read";
    }
    public void ejecutar(Stack<Integer> pila, int[] pc){
        Scanner scanner = new Scanner(System.in);
        int a;
        System.out.print("? ");
        a = scanner.nextInt();
        pila.push(a);
        pc[0]++;
    }
}
