/*
* Fichero: instruccion.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include <string>
#include <stack>

using namespace std;

/*
* Clase abstracta instruccion. Define el atributo nombre que tendran todas las herederas, ademas del constructor
* y el metodo abstracto ejecutar que deberan implementar todas las clases que hereden de esta. Tambien se define
* el metodo nombrar que devuelve el nombre de la instruccion y que no cambiara para las clases herederas.
*/
class Instruccion
{        
    protected:
        // Atributos
        string nombre;

        // Constructor
        Instruccion();
        
    public:
        // Metodo: virtual puro, ejecuta las acciones necesarias sobre la pila o el pc
        void virtual ejecutar(stack<int>& pila, int &pc) = 0;
        // Metodo: devuelve el valor del atributo "nombre"
        string virtual nombrar() = 0;
};
