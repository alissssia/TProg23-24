/*
* Fichero: programa.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include "programa.h"
#include "iostream"

Programa::Programa(int _num_inst)
    : num_inst(_num_inst), instrucciones(new Instruccion*[_num_inst])
{
}

Programa::~Programa() {
    for(int i = 0; i < num_inst; i++)
        delete instrucciones[i];
    delete instrucciones;
}

void Programa::run()
{

    stack<int> pila;
    int pc = 0;

    while(pc < num_inst)
    {
        instrucciones[pc]->ejecutar(pila, pc);
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