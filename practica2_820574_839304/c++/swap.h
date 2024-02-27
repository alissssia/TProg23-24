#pragma once
#include "instruccion.h"

using namespace std;

// Clase heredada de Instruccion
class Swap : public Instruccion
{
    public:
        // Constructor: inicializa el nombre de la instruccion
        Swap();

        // Metodo: extrae los dos primeros elementos de la pila y los vuelve a introducir
        //         en orden inverso
        void ejecutar(stack<int> &pila, int &pc);

        string nombrar();
};
