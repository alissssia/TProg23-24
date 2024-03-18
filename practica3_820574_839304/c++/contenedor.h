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
    protected:
        string de_que;

    public:
    /*
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
    */
        Contenedor(double _volumen)
                : Deposito<T>(_volumen), Carga(_volumen)
        {
            Deposito<T>::name = "Contenedor";
            Carga::name = "Contenedor";
        }

        void aumentar_nivel()
        {
            Deposito<T>::aumentar_nivel();
        }


        friend ostream& operator<<(std::ostream& os, const Contenedor<Carga>& c)
        {
            string corchete = " [";
            string m3 = " m3]";
            string kg = " kg]";
            string de_que = " de Carga Estandar\n";
            
            os << c.nombre() << corchete << to_string(c.Carga::get_volumen()) << m3 << corchete << to_string(c.Carga::get_peso()) << kg << de_que;

            for (T elemento : c.contenido){
                string tabs (elemento.nivel, "  ");
                os << tabs << elemento;
            }

            //os << "\n";

            return os;
        }

        friend ostream& operator<<(std::ostream& os, const Contenedor<SerVivo>& c)
        {
            string corchete = " [";
            string m3 = " m3]";
            string kg = " kg]";
            string de_que = " de Seres Vivos\n";
            
            os << c.nombre() << corchete << to_string(c.get_volumen()) << m3 << corchete << to_string(c.get_peso()) << kg << de_que;

            for (T elemento : c.contenido){
                string tabs (elemento.nivel, "  ");
                os << tabs << elemento;
            }

            //os << "\n";

            return os;
        }

        friend ostream& operator<<(std::ostream& os, const Contenedor<Toxico>& c)
        {
            string corchete = " [";
            string m3 = " m3]";
            string kg = " kg]";
            string de_que = " de Productos Toxicos\n";
            
            os << c.nombre() << corchete << to_string(c.get_volumen()) << m3 << corchete << to_string(c.get_peso()) << kg << de_que;

            for (T elemento : c.contenido){
                string tabs (elemento.nivel, "  ");
                os << tabs << elemento;
            }

            //os << "\n";

            return os;
        }
};