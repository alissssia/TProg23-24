#include "programa.h"

Programa::Programa(int _num_inst)
    : num_inst(_num_inst), instrucciones(new Instruccion*[_num_inst])
{
}

void Programa::run()
{

    PilaInts pila;
    int pc = 0;

    while(pc < num_inst){
        instrucciones[pc]->ejecutar(pila, pc);
    }
}

void Programa::listar()
{
    for(int it = 0; it < num_inst; it++)
    {
        instrucciones[it]->nombrar();
    }
}