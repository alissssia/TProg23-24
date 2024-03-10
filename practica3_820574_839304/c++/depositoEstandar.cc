/*
* Fichero: depositoEstandar.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#include "depositoEstandar.h"

DepositoEstandar::DepositoEstandar(double _capacidad, double _volumen)
                :Deposito<Carga>(_capacidad, _volumen)
{
}