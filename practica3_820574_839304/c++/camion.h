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

            string str_peso = to_string(this->get_peso());
            while (str_peso[str_peso.size() - 1] == '0' || str_peso[str_peso.size() - 1] == '.') str_peso.resize(str_peso.size() - 1);
            
            string str_volumen = to_string(this->get_volumen());
            while (str_volumen[str_volumen.size() - 1] == '0' || str_volumen[str_volumen.size() - 1] == '.') str_volumen.resize(str_volumen.size() - 1);

            string resultado = this->nombre() + " [" + str_volumen + " m3] ["
                                + str_peso + " kg]\n";

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