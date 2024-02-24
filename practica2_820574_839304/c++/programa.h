#pragma once
#include <string>
#include "instruccion.h"
#include "pila_ints.h"

using namespace std;


class Programa
{        
    protected:
        Instruccion** instrucciones;
        int num_inst;
    
    public:
        Programa(int _num_inst);        
        void run();
        void listar();
};
