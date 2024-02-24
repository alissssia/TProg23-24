#include "write.h"
#include <iostream>

Write::Write() {
    nombre = "write";
}

void Write::ejecutar(PilaInts &pila, int &pc) {
    cout << pila.cima();
    pila.extraer();
    pc++;
}

string Write::nombrar() {
    return nombre;
}