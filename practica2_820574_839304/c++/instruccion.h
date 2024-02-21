#include <string>
#include "pila_ints.h"

using namespace std;

class Instruccion
{        
    private:
        string nombre;
    public:
        void virtual ejecutar(PilaInts &pila, int &pc) = 0;
        string virtual nombrar() = 0;
};
