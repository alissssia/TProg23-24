#pragma once
#include <string>
#include "instruccion.h"

using namespace std;

/*
* Clase abstracta Programa. Define el atributo 'num_instr' que guardara el numero de instrucciones que tiene
* el programa implementado, e 'instrucciones', un array de Instrucciones con capacidad de <num_instr> 
* objetos Instruccion. El metodo run ejecuta las instrucciones guardadas en 'instrucciones', y el metodo
* listar las muestra por pantalla.
*/
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
