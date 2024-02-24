#include "swap.h"

Swap::Swap() {
    nombre = "swap";
}

void Swap::ejecutar(PilaInts &pila, int &pc) {
    int a, b;
    a = pila.cima();
    pila.extraer();
    b = pila.cima();
    pila.extraer();

    pila.insertar(a);
    pila.insertar(b);
    pc++;
}

string Swap::nombrar() {
    return nombre;
}