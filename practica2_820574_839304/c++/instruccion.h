#pragma once
#include <string>
#include "pila_ints.h"

using namespace std;


class Instruccion
{        
    protected:
        string nombre;

        Instruccion();
        
    public:
        void virtual ejecutar(PilaInts& pila, int &pc) = 0;
        string virtual nombrar() = 0;
};
