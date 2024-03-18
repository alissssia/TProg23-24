/*
* Fichero: contenedor.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/


#include "contenedor.h"
#include "toxico.h"
#include "servivo.h"

template<>
Contenedor<Toxico>::Contenedor(double _volumen)
                : Deposito<Toxico>(_volumen), Carga(_volumen)
{
    Deposito<Toxico>::name = "Contenedor";
    Carga::name = "Contenedor";
    de_que = "de Productos Toxicos";
}

template<>
Contenedor<SerVivo>::Contenedor(double _volumen)
                : Deposito<SerVivo>(_volumen), Carga(_volumen)
{
    Deposito<SerVivo>::name = "Contenedor";
    Carga::name = "Contenedor";
    de_que = "de Seres Vivos";
}


template<>
Contenedor<Carga>::Contenedor(double _volumen)
                : Deposito<Carga>(_volumen), Carga(_volumen)
{
    Deposito<Carga>::name = "Contenedor";
    Carga::name = "Contenedor";
    de_que = "de Carga Estandar";
}

template <typename T>
double Contenedor<T>::get_peso() const
{
    return Deposito<T>::get_peso();
}

template <typename T>
void Contenedor<T>::aumentar_nivel()
{
    Deposito<T>::aumentar_nivel();
}


template <typename T>
ostream& operator<<(ostream& os,const Contenedor<T>& r)
{   
    os << r.nombre() << "[" << r.get_volumen() << " m3]" << "[" << r.get_peso() << " kg] " << r.de_que << "\n";

    for (T elemento : r.contenido){
        string tabs (elemento.nivel, "  ");
        os << tabs << elemento;
    }

	//os << "\n";

	return os;
}