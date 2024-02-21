#include "instruccion.h"

using namespace std;

class Add : public Instruccion 
{
    private:
        string nombre;
    public:
        void add();
        void ejecutar(PilaInts &pila, int &pc);
        string nombrar();
};
