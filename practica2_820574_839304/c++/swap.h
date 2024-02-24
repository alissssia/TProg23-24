#include "instruccion.h"

using namespace std;

class Swap : public Instruccion
{
    private:
        string nombre;
        
    public:
        Swap();
        void ejecutar(PilaInts &pila, int &pc);
        string nombrar();
};
