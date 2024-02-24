#include "instruccion.h"

using namespace std;

class Over : public Instruccion
{
    private:
        string nombre;
        
    public:
        Over();
        void ejecutar(PilaInts &pila, int &pc);
        string nombrar();
};
