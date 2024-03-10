/*
* Fichero: contenedor.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "deposito.h"
#include "carga.h"


class Contenedor : public Deposito<Carga>, public Carga{
    
    public:
    Contenedor(double _volumen);
    double get_peso();
    friend ostream& operator<<(std::ostream& os, const Deposito<Carga>& c);
};