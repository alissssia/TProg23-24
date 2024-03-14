/*
* Fichero: camion.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#include "camion.h"
#include "carga.h"

Camion::Camion(double _volumen)
                :Deposito(_volumen)
{
    name = "Camion";
}