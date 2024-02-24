#include "programa.h"
#include "iostream"

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
        cout << "-- " << pila.cima() << " --" << endl;
    }
}

void Programa::listar()
{
    for(int it = 0; it < num_inst; it++)
    {
        cout << it << " " << instrucciones[it]->nombrar() << endl;
    }
    cout << endl;
}