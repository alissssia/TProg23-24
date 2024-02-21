#include "instruccion.h"

class add : public Instruccion {
    public:
        void ejecutar(PilaInts &pila, int &pc);
        string nombrar();
}