#include "add.h"

void add::ejecutar(PilaInts &pila, int &pc) {
    int a, b;
    pila.cima(a);
    pila.extraer();
    pila.cima(b);
    pila.extraer();
    pila.insertar(a + b);
}