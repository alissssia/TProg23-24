#pragma once
#include "instruccion.h"

// Clase heredada de Instruccion
class Write : public Instruccion {
    public:
        // Constructor: inicializa el nombre de la instruccion
        Write();
        
        // Metodo: extrae y escribe por pantalla el primer elemento de la pila, 
        //         y aumenta en 1 el pc
        void ejecutar(stack<int> &pila, int &pc);
        string nombrar();
};