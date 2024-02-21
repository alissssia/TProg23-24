#include "instruccion.h"

class Read : public Instruccion {
    public:
        Read();
        void ejecutar(PilaInts &pila, int &pc);
        string nombrar();
};

