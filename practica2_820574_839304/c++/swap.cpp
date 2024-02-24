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

    pila.insertar(b);
    pila.insertar(a);
    pc++;
}

string Swap::nombrar() {
    return nombre;
}