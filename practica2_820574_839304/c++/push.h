#include "instruccion.h"

// Clase heredada de Instruccion
class Push : public Instruccion {
    private:
        // Atributos
        int num;

    public:
        // Constructor: el numero pasado por parametro sera guardado en el atributo 'num'
        Push(int _num);

        // Metodo: introduce 'valor' en la pila y aumenta en 1 el pc
        void ejecutar(stack<int> &pila, int &pc);
        
        string nombrar();
};
