#include "read.h"
#include <iostream>

Read::Read() {
    nombre = "read";
}

void Read::ejecutar(PilaInts &pila, int &pc) {
    int a;
    cin >> a;
    pila.insertar(a);
}

string Read::nombrar() {
    return nombre;
}