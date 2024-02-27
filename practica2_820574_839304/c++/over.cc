#include "over.h"

Over::Over() {
    nombre = "over";
}

void Over::ejecutar(PilaInts &pila, int &pc) {
    int a, b;
    a = pila.cima();
    pila.extraer();
    b = pila.cima();
    pila.extraer();

    pila.insertar(b);
    pila.insertar(a);
    pila.insertar(b);
    pc++;
}

string Over::nombrar() {
    return nombre;
}