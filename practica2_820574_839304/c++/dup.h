#include "instruccion.h"

class Dup : public Instruccion {
    
    public:
        Dup();
        void ejecutar(PilaInts &pila, int &pc);
        string nombrar();
};
