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
        virtual string nombre() const {            
            return name;            
        }
        double get_volumen() const {
            return volumen;
        
        }
        string get_descripcion() const {
            return nombre() + " [" + to_string(get_volumen()) + " m3] [" + to_string(get_peso()) + " kg]";
        
        }
        int get_nivel() const {
            return nivel;
        }
        virtual void aumentar_nivel() = 0;
        virtual double get_peso() const = 0;
};