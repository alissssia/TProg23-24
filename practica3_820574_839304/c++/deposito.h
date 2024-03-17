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
        vector<T*> contenido;

        // constructor
        Deposito(double _volumen);
        Deposito<T>::Deposito(double _volumen)
                 :Inventario(_volumen)
        {
            espacio_libre = _volumen;   // Inicialmente el depósito estará vacío,
                                        // por lo que todo el volumen estará disponible
        }

    public:
        bool guardar(T* c);
        bool Deposito<T>::guardar(T* c)
        {
            if (c->get_volumen() <= espacio_libre)
            {   
                c->aumentar_nivel();
                contenido.push_back(c);
                espacio_libre -= c->get_volumen();
                return true;
            }
            else
            {
                return false;
            }
        }

        void aumentar_nivel() override;
        void Deposito<T>::aumentar_nivel()
        {
            nivel+=1;

            for(T* elemento : contenido)
            {
                elemento->aumentar_nivel();
            }
        }


        double get_peso() const override;
        double Deposito<T>::get_peso() const
        {
            double peso = 0.0;

            for (T* elemento : contenido){
                peso += elemento->get_peso();
            }

            return peso;
        }
};