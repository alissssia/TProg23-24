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
