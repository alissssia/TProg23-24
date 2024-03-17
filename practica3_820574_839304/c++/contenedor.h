/*
* Fichero: contenedor.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "deposito.h"
#include "carga.h"

template <typename T>
class Contenedor : public Deposito<T>, public Carga {
    protected:
        string de_que;

    public:
        Contenedor(double _volumen);
        Contenedor<Toxico>::Contenedor(double _volumen)
                : Deposito<Toxico>(_volumen), Carga(_volumen)
        {
            Deposito<Toxico>::name = "Contenedor";
            Carga::name = "Contenedor";
            de_que = "de Productos Toxicos";
        }

        Contenedor<SerVivo>::Contenedor(double _volumen)
                : Deposito<SerVivo>(_volumen), Carga(_volumen)
        {
            Deposito<SerVivo>::name = "Contenedor";
            Carga::name = "Contenedor";
            de_que = "de Seres Vivos";
        }

        Contenedor<Carga>::Contenedor(double _volumen)
                : Deposito<Carga>(_volumen), Carga(_volumen)
        {
            Deposito<Carga>::name = "Contenedor";
            Carga::name = "Contenedor";
            de_que = "de Carga Estandar";
        }


        void aumentar_nivel() override;
        void Contenedor<T>::aumentar_nivel()
        {
            Deposito<T>::aumentar_nivel();
        }


        double get_peso() const override;
        double Contenedor<T>::get_peso() const
        {
            return Deposito<T>::get_peso();
        }


        friend ostream& operator<<(std::ostream& os, const Deposito<Carga>& c)
        {   
            os << r.nombre() << "[" << r.get_volumen() << " m3]" << "[" << r.get_peso() << " kg] " << r.de_que << "\n";

            for (T elemento : r.contenido){
                string tabs (elemento.nivel, "  ");
                os << tabs << elemento;
            }

            //os << "\n";

            return os;
        }
};