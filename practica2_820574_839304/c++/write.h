#include "instruccion.h"

class Write : public Instruccion {
    public:
        Write();
        void ejecutar(PilaInts &pila, int &pc);
        string nombrar();
};