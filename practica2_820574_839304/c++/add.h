#include "instruccion.h"

class add : public Instruccion {
    public:
        add();
        void ejecutar(PilaInts &pila, int &pc);
        string nombrar();
}