#include "dup.h"

Dup::Dup() {
    nombre = "dup";
}

void Dup::ejecutar(PilaInts &pila, int &pc) {
    int a;
    a = pila.cima();
    pila.extraer();
    pila.insertar(a);
    pila.insertar(a);
    pc++;
}

string Dup::nombrar() {
    return nombre;
}