/*
* Fichero: camion.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#include "camion.h"

Camion::Camion(double _volumen)
                :Deposito<Carga>(_volumen)
{
    name = "Camion";
}