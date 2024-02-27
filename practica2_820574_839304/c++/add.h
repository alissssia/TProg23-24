/*
* Fichero: add.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
#pragma once
#include "instruccion.h"

using namespace std;

// Clase heredada de Instruccion
class Add : public Instruccion
{       
    public:
        // Constructor: inicializa el nombre de la instruccion

        Add();

        // Metodo: Extrae los dos primeros elementos de la pila, inserta su suma y aumenta el pc en 1
        void ejecutar(stack<int> &pila, int &pc);
};
