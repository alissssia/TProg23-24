/*
* Fichero: prodgenerico.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#include "prodgenerico.h"

ProdGenerico::ProdGenerico(double _volumen, string _nombre, double _peso)
            :Inventario(_volumen), peso(_peso)
{
    nombre = _nombre;
}

double ProdGenerico::get_peso()
{
    return peso;
}


string ProdGenerico::to_string()
{
    return nombre;
}
