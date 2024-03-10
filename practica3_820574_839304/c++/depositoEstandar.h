/*
* Fichero: depositoEstandar.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "deposito.h"

class DepositoEstandar : public Deposito<Carga> {
    protected:
    DepositoEstandar(double _capacidad, double _volumen);
};