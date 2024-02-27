/*
* Fichero: Programa.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

/*
* Clase abstracta Programa. Define el atributo 'num_instr' que guardara el numero de instrucciones que tiene
* el programa implementado, e 'instrucciones', un array de Instrucciones con capacidad de <num_instr> 
* objetos Instruccion. El metodo run ejecuta las instrucciones guardadas en 'instrucciones', y el metodo
* listar las muestra por pantalla.
*/
abstract class Programa {
    protected Instruccion[] instrucciones;
    protected int num_instr;

    Programa(int _num_instr){
        num_instr = _num_instr;
        instrucciones = new Instruccion[num_instr];
    }

    public void run() {
        Stack<Integer> pila = new Stack<Integer>();
        int[] pc = {0};
        while (pc[0] < num_instr) {
            instrucciones[pc[0]].ejecutar(pila, pc);
        }
    }

    public void listar() {
        for (int i = 0; i < instrucciones.length; i++) {
            System.out.println(i + " " + instrucciones[i].nombrar());
        }
        System.out.println();
    }
}
