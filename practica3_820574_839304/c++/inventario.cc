/*
* Fichero: inventario.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#include "inventario.h"

Inventario::Inventario(double _volumen)
                :volumen(_volumen)
{
    nivel = 0;
}

string Inventario::nombre() const
{
    return name;
}

string Inventario::get_descripcion() const
{
    return nombre() + " [" + to_string(get_volumen()) + " m3] [" + to_string(get_peso()) + " kg]";
}

int Inventario::get_nivel() const
{
    return nivel;
}

double Inventario::get_volumen() const
{
    return volumen;
}