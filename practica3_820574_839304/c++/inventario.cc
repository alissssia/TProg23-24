/*
* Fichero: inventario.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
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