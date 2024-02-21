#include "write.h"

Write::Write() {
    nombre = "write";
}

void Write::ejecutar(PilaInts &pila, int &pc) {
    int a;
    pila.cima(a);
    pila.extraer();
    cout << a << endl;
}

string Write::nombrar() {
    return nombre;
}