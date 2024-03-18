/*
* Fichero: carga.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "inventario.h"

using namespace std;

class Carga : public virtual Inventario{
    
    protected:
        Carga(double _volumen)
            : Inventario(_volumen)
        {
        }

    public:
        virtual void aumentar_nivel() = 0;
        virtual double get_peso() const = 0;

        static string de_que()
        {
            return "de Carga Estandar";
        }

        //virtual string descripcion() const = 0;
        
        virtual string descripcion() const
        {
            string resultado = this->nombre() + " [" + to_string(this->get_volumen()) + " m3] ["
                                + to_string(this->get_peso()) + " kg]\n";
            return resultado;
        }
        

        friend ostream& operator<<(ostream& os,const Carga& c)
        {
            os << c.descripcion();
            return os;
        }

};