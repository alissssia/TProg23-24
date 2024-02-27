/*
* Fichero: write.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include "write.h"
#include <iostream>

Write::Write() {
    nombre = "write";
}

void Write::ejecutar(stack<int> &pila, int &pc) {
    cout << pila.top() << endl;
    pila.pop();
    pc++;
}