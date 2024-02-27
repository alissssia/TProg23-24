/*
* Fichero: jump_if.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include "jump_if.h"

Jump_If::Jump_If(int _num) {
    nombre = "jumpif";
    num = _num;
}

void Jump_If::ejecutar(stack<int> &pila, int &pc) {
    int a = pila.top();
    pila.pop();
    if(a >= 0)
    {
        pc = num;
    } else 
    {
        pc++;
    }
}

string Jump_If::nombrar() {
    return nombre;
}