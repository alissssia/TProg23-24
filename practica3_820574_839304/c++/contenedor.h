/*
* Fichero: contenedor.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "deposito.h"
#include "carga.h"

template <typename T>
class Contenedor : public Deposito<T>, public Carga {
    protected:
        string de_que;

    public:
        Contenedor(double _volumen);
        void aumentar_nivel() override;
        double get_peso() const override;
        friend ostream& operator<<(std::ostream& os, const Deposito<Carga>& c);
};