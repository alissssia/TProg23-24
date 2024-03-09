/*
* Fichero: inventario.cc
* Autores: Alicia Laz   aro Huerta y Manel Jorda Puig Rubio
* Fecha: 29/02/2024
*/

#include "inventario.h"

Inventario::Inventario(double _volumen)
                :volumen(_volumen)
{
}

string Inventario::get_nombre()
{
    return nombre;
}

double Inventario::get_volumen()
{
    return volumen;
}