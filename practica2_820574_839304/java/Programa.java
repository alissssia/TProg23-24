package practica2_820574_839304.java;
import java.util.LinkedList;
import java.util.Queue;

public class Programa {
    protected Pila_ints pila;
    protected Instruccion[] instrucciones;

    Programa(){
    }

    public void run() {
        // falta la lista
        Queue<Instruccion> lista = new LinkedList<Instruccion>();

    }

    public void listar() {
        for (int i = 0; i < instrucciones.length; i++) {
            System.out.println(i + " " + instrucciones[i].listar());
        }
    }
}
