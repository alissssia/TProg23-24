#include "write.h"
#include <iostream>

Write::Write() {
    nombre = "write";
}

void Write::ejecutar(PilaInts &pila, int &pc) {
    int a;
    a = pila.cima();
    pila.extraer();
    cout << a << endl;
}

string Write::nombrar() {
    return nombre;
}