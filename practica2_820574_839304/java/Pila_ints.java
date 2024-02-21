package practica2_820574_839304.java;
import java.util.Stack;

public class Pila_ints {
    Stack<Integer> pila;

    Pila_ints(){
        pila = new Stack<Integer>();
    }

    public void insertar(int n){
        pila.push(n);
    }

    public int extraer(){
        return pila.pop();
    }

    public int cima(){
        return pila.peek();
    }
}
