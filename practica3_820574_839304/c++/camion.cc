/*
* Fichero: camion.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#include "camion.h"

Camion::Camion(double _capacidad)
                :DepositoEstandar(_capacidad, 0) // ese 0 hay que mirar porque es el volumen y es muy sus
{
    nombre = "Camion";
}