#include "instruccion.h"

class Jump_If : public Instruccion {
    private:
        int num;

    public:
        Jump_If(int _num);
        void ejecutar(PilaInts &pila, int &pc);
        string nombrar();
};
