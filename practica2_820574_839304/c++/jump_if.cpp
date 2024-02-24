#include "jump_if.h"

Jump_If::Jump_If(int _num) {
    nombre = "jumpif";
    num = _num;
}

void Jump_If::ejecutar(PilaInts &pila, int &pc) {
    int a = pila.cima();
    pila.extraer();
    if(a >= 0)
    {
        pc = num;
    }
}

string Jump_If::nombrar() {
    return nombre;
}