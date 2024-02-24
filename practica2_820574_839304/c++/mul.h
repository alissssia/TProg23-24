#include "instruccion.h"

using namespace std;

class Mul : public Instruccion
{
    private:
        string nombre;
        
    public:
        Mul();
        void ejecutar(PilaInts &pila, int &pc);
        string nombrar();
};
