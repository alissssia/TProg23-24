/*
* Fichero: carga.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#include "carga.h"

Carga::Carga(double _volumen)
        :Inventario(_volumen)
{
}

std::ostream& operator<<(std::ostream& os, const Carga* carga) {
    
    os << carga->nombre();
    return os;
}
