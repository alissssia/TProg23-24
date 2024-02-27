/*
* Fichero: read.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include "read.h"
#include <iostream>

Read::Read() {
    nombre = "read";
}

void Read::ejecutar(stack<int> &pila, int &pc) {
    int a;
    cout << "? ";
    cin >> a;
    pila.push(a);
    pc++;
}