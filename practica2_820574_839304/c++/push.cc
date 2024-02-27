#include "push.h"

Push::Push(int _num) {
    nombre = "push";
    num = _num;
}

void Push::ejecutar(PilaInts &pila, int &pc) {
    pila.insertar(num);
    pc++;
}

string Push::nombrar() {
    return nombre;
}