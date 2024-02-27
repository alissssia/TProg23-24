#include "mul.h"

Mul::Mul() {
    nombre = "mul";
}

void Mul::ejecutar(PilaInts &pila, int &pc) {
    int a, b;
    a = pila.cima();
    pila.extraer();
    b = pila.cima();
    pila.extraer();
    pila.insertar(a * b);
    pc++;
}

string Mul::nombrar() {
    return nombre;
}