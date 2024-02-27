/*
* Fichero: over.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
#pragma once
#include "instruccion.h"

using namespace std;

// Clase heredada de Instruccion
class Over : public Instruccion
{       
    public:
        // Constructor: inicializa el nombre de la instruccion
        Over();

        // Metodo: Extrae los dos primeros elementos de la pila, los vuelve a insertar en el
        //         mismo orden e inserta otra vez el segundo extraido, y aumenta en 1 el pc
        void ejecutar(stack<int> &pila, int &pc) override;
};
