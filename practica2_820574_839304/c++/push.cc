/*
* Fichero: push.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include "push.h"

Push::Push(int _num) {
    nombre = "push";
    num = _num;
}

void Push::ejecutar(stack<int> &pila, int &pc) {
    pila.push(num);
    pc++;
}

string Push::nombrar() {
    return nombre;
}