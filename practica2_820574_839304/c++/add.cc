/*
* Fichero: add.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include "add.h"

Add::Add() {
    nombre = "add";
}

void Add::ejecutar(stack<int> &pila, int &pc) {
    int a, b;
    a = pila.top();
    pila.pop();
    b = pila.top();
    pila.pop();
    pila.push(a + b);
    pc++;
}
