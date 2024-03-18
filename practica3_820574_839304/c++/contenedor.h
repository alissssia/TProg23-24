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
            string resultado = this->nombre() + " [" + to_string(this->get_volumen()) + " m3] ["
                                + to_string(this->get_peso()) + " kg] " + T::de_que() + "\n";

            for (T* elemento : this->contenido){
                string tabs = "";
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