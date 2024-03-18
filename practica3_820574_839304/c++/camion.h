/*
* Fichero: camion.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "deposito.h"
#include "carga.h"

class Camion : public Deposito<Carga>{

    public:
        Camion(double _volumen)
            : Inventario(_volumen), Deposito<Carga>(_volumen)
        {
            name = "Camion";
        }

        string descripcion() const
        {
            string resultado = this->nombre() + " [" + to_string(this->get_volumen()) + " m3] ["
                                + to_string(this->get_peso()) + " kg]\n";

            for (Carga* elemento : this->contenido){
                string tabs = "";
                for(int i = 0; i < elemento->get_nivel(); i++)
                {
                    tabs += "  ";
                }

                resultado += tabs + elemento->descripcion();
            }
            
            return resultado;
        }

        friend ostream& operator<<(ostream& os,const Camion& c) {
            os << c.descripcion();
            return os;
        }
};