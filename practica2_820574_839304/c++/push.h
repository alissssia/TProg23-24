#include "instruccion.h"

class Push : public Instruccion {
    private:
        int num;

    public:
        Push(int _num);
        void ejecutar(PilaInts &pila, int &pc);
        string nombrar();
};
