/*
* Fichero: camion.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "deposito.h"
#include "carga.h"

class Camion : public Deposito<Carga>{

    public:
        Camion(double _volumen);
        friend ostream& operator<<(ostream& os,const Camion& r);
};