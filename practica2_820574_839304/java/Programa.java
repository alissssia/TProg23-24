package practica2_820574_839304.java;
import java.util.LinkedList;
import java.util.Queue;

public class Programa {
    protected Instruccion[] instrucciones;
    protected int num_instr;

    Programa(int _num_instr){
        num_instr = _num_instr;
        instrucciones = new Instruccion[num_instr];
    }

    public void run() {
        Queue<Integer> cola = new LinkedList<Integer>();
        Pila_ints pila = new Pila_ints();
        int[] pc = {0};
        while (pc[0] < num_instr) {
            instrucciones[pc[0]].ejecutar(pila, pc);
        }
    }

    public void listar() {
        for (int i = 0; i < instrucciones.length; i++) {
            System.out.println(i + " " + instrucciones[i].nombrar() + "\n");
        }
    }
}
