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

        Inventario(double _volumen)
            :volumen(_volumen)
        {
            nivel = 0;
        }

    public:
        
        string nombre() const
        {
            return name;
        }

        double get_volumen() const
        {
            return volumen;
        }

        int get_nivel() const
        {
            return nivel;
        }
};