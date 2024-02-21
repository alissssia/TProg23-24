#include "add.h"

add::add() {
    nombre = "add";
}

void add::ejecutar(PilaInts &pila, int &pc) {
    int a, b;
    pila.cima(a);
    pila.extraer();
    pila.cima(b);
    pila.extraer();
    pila.insertar(a + b);
}

string add::nombrar() {
    return nombre;
}