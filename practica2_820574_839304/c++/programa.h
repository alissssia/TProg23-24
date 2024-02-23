#include <string>
#include "instruccion.h"
#include "pila_ints.h"

using namespace std;
using InstruccionPt = Instruccion*;

class Programa
{        
    protected:
        InstruccionPt* instrucciones;
        int num_inst;

        Programa(int _num_inst);

    public:
        
        void run();
        void listar();
};
