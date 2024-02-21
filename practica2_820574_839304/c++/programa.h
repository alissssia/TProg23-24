#include <string>
#include "instruccion.h"
#include "pila_ints.h"

using namespace std;
using InstruccionPt = Instruccion*;

class Programa
{        
    private:
        InstruccionPt* instrucciones;
        PilaInts pila;

    public:
        void run();
        void listar();
};
