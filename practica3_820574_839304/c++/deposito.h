/*
* Fichero: deposito.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "inventario.h"
#include <vector>

template <typename T>
class Deposito : public Inventario{
    
    protected: 
        vector<T> contenido;

        // constructor
        Deposito(double _volumen);

    public:
        bool guardar(T* c);
        void aumentar_nivel() override;
        double get_peso() const override;
};