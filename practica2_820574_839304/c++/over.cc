/*
* Fichero: over.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include "over.h"

Over::Over() {
    nombre = "over";
}

void Over::ejecutar(stack<int> &pila, int &pc) {
    int a, b;
    a = pila.top();
    pila.pop();
    b = pila.top();
    pila.pop();

    pila.push(b);
    pila.push(a);
    pila.push(b);
    pc++;
}

string Over::nombrar() {
    return nombre;
}