/*
* Fichero: carga.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "inventario.h"

using namespace std;

class Carga : public Inventario{
    
    protected: 
        Carga(double _volumen) 
            :Inventario(_volumen)
        {
        }



    
    public:
        virtual void aumentar_nivel();
        virtual double get_peso();
        friend ostream& operator<<(ostream& os,const Carga& c)
        {
            return os;
        }

};