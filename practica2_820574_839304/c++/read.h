#pragma once
#include "instruccion.h"

// Clase heredada de Instruccion
class Read : public Instruccion {
    public:
        // Constructor: inicializa el nombre de la instruccion
        Read();

        // Metodo: pide por pantalla que el usuario introduzca un valor y aumenta en 1 el pc
        void ejecutar(stack<int> &pila, int &pc);

        string nombrar();
};

