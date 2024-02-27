/*
* Fichero: mul.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
#pragma once
#include "instruccion.h"

using namespace std;


class Mul : public Instruccion
{       
    public:
        // Constructor: inicializa el nombre de la instruccion
        Mul();

        // Metodo: Extrae los dos primeros elementos de la pila, 
        //          inserta su producto y aumenta en 1 el pc
        void ejecutar(stack<int> &pila, int &pc);
        
        string nombrar();
};
