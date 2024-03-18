/*
* Fichero: contenedor.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "deposito.h"
#include "carga.h"
#include "servivo.h"
#include "toxico.h"

#include <iostream>

template <typename T>
class Contenedor : public Deposito<T>, public Carga {

    public:
    
        Contenedor(double _volumen)
                : Inventario(_volumen), Deposito<T>(_volumen), Carga(_volumen)
        {
            Carga::name = "Contenedor";
        }

        string nombre() const
        {
            return Carga::nombre();
        }

        double get_volumen() const
        {
            return Carga::get_volumen();
        }

        double get_peso() const
        {
            return Deposito<T>::get_peso();
        }

        void aumentar_nivel()
        {
            nivel+=1;

            for(T* elemento : this->contenido)
            {
                elemento->aumentar_nivel();
            }
        }

        string descripcion() const
        {

            string str_peso = to_string(this->get_peso());
            while (str_peso[str_peso.size() - 1] == '0' || str_peso[str_peso.size() - 1] == '.') str_peso.resize(str_peso.size() - 1);
            
            string str_volumen = to_string(this->get_volumen());
            while (str_volumen[str_volumen.size() - 1] == '0' || str_volumen[str_volumen.size() - 1] == '.') str_volumen.resize(str_volumen.size() - 1);

            string resultado = this->nombre() + " [" + str_volumen + " m3] ["
                                + str_peso + " kg] " + T::de_que() + "\n";

            for (T* elemento : this->contenido){
                string tabs = "";

                cout << elemento->nombre() << " " << to_string(elemento->get_nivel()) << endl;

                for(int i = 0; i < elemento->get_nivel(); i++)
                {
                    tabs += "  ";
                }
                resultado += tabs + elemento->descripcion();
            }
            
            return resultado;
        }

        friend ostream& operator<<(std::ostream& os, const Contenedor<T>& c)
        {
            os << c.descripcion();
            return os;
        }
};