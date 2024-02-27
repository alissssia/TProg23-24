/*
* Fichero: swap.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include "swap.h"

Swap::Swap() {
    nombre = "swap";
}

void Swap::ejecutar(stack<int> &pila, int &pc) {
    int a, b;
    a = pila.top();
    pila.pop();
    b = pila.top();
    pila.pop();

    pila.push(a);
    pila.push(b);
    pc++;
}

string Swap::nombrar() {
    return nombre;
}