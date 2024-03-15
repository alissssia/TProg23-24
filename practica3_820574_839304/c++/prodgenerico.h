/*
* Fichero: prodgenerico.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "inventario.h"

using namespace std;

class ProdGenerico : public Inventario {
    protected:
        double peso;

        ProdGenerico(const string& _nombre, double _volumen, double _peso);

    public:
        virtual string nombre() const ;
        double get_peso() const override;
        void aumentar_nivel() override;
};
