#include "read.h"
#include <iostream>

Read::Read() {
    nombre = "read";
}

void Read::ejecutar(PilaInts &pila, int &pc) {
    int a;
    cout << "? ";
    cin >> a;
    pila.insertar(a);
    pc++;
}

string Read::nombrar() {
    return nombre;
}