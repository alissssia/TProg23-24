/*
* Fichero: contenedor.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/


#include "contenedor.h"
#include "toxico.h"
#include "servivo.h"

Contenedor<Toxico>::Contenedor(double _volumen)
                : Deposito<Toxico>(_volumen), Carga(_volumen)
{
    Deposito::name = "Contenedor";
    Carga::name = "Contenedor";
    de_que = "de Productos Toxicos";
}

Contenedor<SerVivo>::Contenedor(double _volumen)
                : Deposito<SerVivo>(_volumen), Carga(_volumen)
{
    Deposito::name = "Contenedor";
    Carga::name = "Contenedor";
    de_que = "de Seres Vivos";
}

template <typename T>
Contenedor<T>::Contenedor(double _volumen)
                : Deposito<T>(_volumen), Carga(_volumen)
{
    Deposito::nombre = "Contenedor";
    Carga::name = "Contenedor";
    de_que = "de Carga Estandar";
}

template <typename T>
double Contenedor<T>::get_peso() const
{
    return Deposito::get_peso();
}

template <typename T>
void Contenedor<T>::aumentar_nivel()
{
    Deposito::aumentar_nivel();
}


template <typename T>
ostream& operator<<(ostream& os,const Deposito<T>& r)
{   
    os << r.nombre() << "[" << r.get_volumen() << " m3]" << "[" << r.get_peso() << " kg] <<\n";

    for (T elemento : r.contenido){
        string tabs (elemento.nivel, "  ");
        os << tabs << elemento;
    }

	os << "\n";

	return os;
}