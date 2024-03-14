/*
* Fichero: inventario.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include <string>

using namespace std;


class Inventario
{
    protected:
        string name;
        double volumen;
        double espacio_libre;
        int nivel;

        Inventario(double _volumen);

    public:
        string nombre() const;
        double get_volumen() const;
        string get_descripcion() const;
        virtual void aumentar_nivel() = 0;
        virtual double get_peso() const = 0;
};