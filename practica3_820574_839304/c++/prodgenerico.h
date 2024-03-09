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

        ProdGenerico(double _volumen, string _nombre, double _peso);

    public:
        double get_peso() override;
        string to_string() override;
};
