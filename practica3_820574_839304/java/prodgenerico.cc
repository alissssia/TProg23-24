/*
* Fichero: prodgenerico.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#include "prodgenerico.h"

ProdGenerico::ProdGenerico(const string& _nombre, double _volumen, double _peso)
            :Inventario(_volumen), peso(_peso)
{
    name = _nombre;
}

double ProdGenerico::get_peso() const
{
    return peso;
}

void ProdGenerico::aumentar_nivel()
{
    nivel+=1;
}


ostream& operator<<(ostream& os, const ProdGenerico& r)
{
    os << r.get_descripcion();
    return os;
}
