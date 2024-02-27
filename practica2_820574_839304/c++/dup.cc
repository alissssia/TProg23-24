/*
* Fichero: dup.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include "dup.h"

Dup::Dup() {
    nombre = "dup";
}

void Dup::ejecutar(stack<int> &pila, int &pc) {
    int a;
    a = pila.top();
    pila.pop();
    pila.push(a);
    pila.push(a);
    pc++;
}