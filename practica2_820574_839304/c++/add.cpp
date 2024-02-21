#include "add.h"

Add::Add() {
    nombre = "add";
}

void Add::ejecutar(PilaInts &pila, int &pc) {
    int a, b;
    a = pila.cima();
    pila.extraer();
    b = pila.cima();
    pila.extraer();
    pila.insertar(a + b);
}

string Add::nombrar() {
    return nombre;
}