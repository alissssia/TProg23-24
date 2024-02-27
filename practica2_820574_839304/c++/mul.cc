/*
* Fichero: mul.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include "mul.h"

Mul::Mul() {
    nombre = "mul";
}

void Mul::ejecutar(stack<int> &pila, int &pc) {
    int a, b;
    a = pila.top();
    pila.pop();
    b = pila.top();
    pila.pop();
    pila.push(a * b);
    pc++;
}