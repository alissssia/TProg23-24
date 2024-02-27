/*
* Fichero: jump_if.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
#include "instruccion.h"

// Clase heredada de Instruccion
class Jump_If : public Instruccion {
    private:
        // Atributos
        int num;

    public:
        // Constructor: el numero pasado por parametro sera guardado en el atributo 'num'
        Jump_If(int _num);

        // Metodo: extrae el primer elemento de la pila
        //      si es mayor o igual que cero, modifica el pc igual que "valor"
        //      si es menor que cero, aumenta el pc en 1
        void ejecutar(stack<int> &pila, int &pc);
        string nombrar();
};
