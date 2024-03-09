/*
* Fichero: inventario.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 29/02/2024
*/

#pragma once
#include <string>

using namespace std;

class Inventario
{
    
protected:
    string nombre;
    double volumen;

    Inventario(double _volumen);

public:
    string get_nombre();
    double get_volumen();
    virtual double get_peso() = 0;
    virtual string to_string() = 0;
};