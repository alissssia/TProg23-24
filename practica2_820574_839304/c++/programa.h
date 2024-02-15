#include <string>
#include "instruccion.h"

using namespace std;
using InstruccionPt = Instruccion*;

class Programa
{        
    private:
        InstruccionPt* instrucciones;

    public:
        void run();
        void listar();
};
