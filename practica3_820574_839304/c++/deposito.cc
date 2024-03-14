/*
* Fichero: deposito.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#include "deposito.h"

template <typename T> 
Deposito<T>::Deposito(double _volumen)
                 :Inventario(_volumen)
{
    espacio_libre = _volumen;   // Inicialmente el depósito estará vacío,
                                // por lo que todo el volumen estará disponible
}

template <typename T>
double Deposito<T>::get_peso() const
{
    double peso = 0.0;

    for (T elemento : contenido){
        peso += elemento.get_peso();
    }

    return peso;
}

template <typename T>
void Deposito<T>::aumentar_nivel()
{
    nivel+=1;

    for(T& elemento : contenido)
    {
        elemento.aumentar_nivel();
    }
}

template <typename T>
bool Deposito<T>::guardar(T& c)
{
    if (c.get_volumen() <= espacio_libre)
    {   
        c.aumentar_nivel();
        contenido.push_back(c);
        espacio_libre -= c->get_volumen();
        return true;
    }
    else
    {
        return false;
    }
}

