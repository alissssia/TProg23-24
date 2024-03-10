/*
* Fichero: deposito.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#include "deposito.h"

template <class T> Deposito<T>::Deposito(double _capacidad, double _volumen)
                :Inventario(_volumen), capacidad(_capacidad)
{
    peso = 0.0;
}

template <class T> double Deposito<T>::get_peso()
{
    return peso;
}


template <class T> bool Deposito<T>::guardar(T& c)
{
    if (c.get_volumen() + volumen <= capacidad)
    {
        cosasDentro.push_back(c);
        volumen += c->get_volumen();
        peso += c->get_peso();
        return true;
    }
    else
    {
        return false;
    }
}

