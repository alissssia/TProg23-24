/*
* Fichero: deposito.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "inventario.h"
#include "carga.h"
#include <vector>

template <class T>
class Deposito : public Inventario{
    
    protected: 
    double capacidad;
    double peso;
    vector<Carga> cosasDentro;

    // constructor
    Deposito(double _capacidad, double _volumen);

    public:
    virtual bool guardar(T& c);
    double get_peso() override;
    friend ostream& operator<<(std::ostream& os, const Deposito<Carga>& c);
};