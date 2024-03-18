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
            :Deposito<Carga>(_volumen)
        {
            name = "Camion";
        }

        string nombre() const
        {
            return name;
        }

        friend ostream& operator<<(ostream& os,const Camion& c) {
            string corchete = " [";
            string m3 = " m3]";
            string kg = " kg]\n";
            
            os << c.nombre() << corchete << to_string(c.get_volumen()) << m3 << corchete << to_string(c.get_peso()) << kg;

            for (Carga* elemento : c.contenido){
                string tabs = "";
                for(int i = 0; i < elemento->get_nivel(); i++)
                {
                    tabs += "  ";
                }
                os << tabs;
                os << elemento;
            }

            //os << "\n";

            return os;
        }
};