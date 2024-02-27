/*
* Fichero: pila_ints.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include "pila_ints.h"

PilaInts::PilaInts(){}

void PilaInts::insertar(int a)
{
    pila.push(a);
}
        
void PilaInts::extraer()
{
    pila.pop();
}

int PilaInts::cima()
{
    return pila.top();
}
