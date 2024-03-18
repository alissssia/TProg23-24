/*
* Fichero: camion.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#include "camion.h"

Camion::Camion(double _volumen)
                :Deposito<Carga>(_volumen)
{
    name = "Camion";
}

ostream& operator<<(ostream& os,const Camion& c)
{
    string corchete = "[";
    string m3 = " m3]";
    string kg = " kg]\n";
    
    os << c.nombre() << corchete << to_string(c.get_volumen()) << m3 << corchete << to_string(c.get_peso()) << kg;

    for (Carga* elemento : c.contenido){
        string tabs = "";
        for(int i = 0; i < elemento->get_nivel(); i++)
        {
            tabs += "  ";
        }
        os << tabs << elemento;
    }

	//os << "\n";

	return os;
}