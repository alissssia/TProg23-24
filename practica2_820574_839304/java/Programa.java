/*
* Fichero: Programa.java
* Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
* Fecha: 27/02/2023
*/
import java.util.Stack;

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
    }
}
