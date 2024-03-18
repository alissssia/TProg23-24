/*
* Fichero: prodgenerico.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "inventario.h"

using namespace std;

class ProdGenerico : public Inventario {
    protected:
        double peso;

        ProdGenerico(const string& _nombre, double _volumen, double _peso)
                    :Inventario(_volumen), peso(_peso)
        {
            name = _nombre;
        }

    public:

        string nombre() const
        {
            return name;
        }
      
        double get_peso() const
        {
            return peso;
        }

        void aumentar_nivel()
        {
            nivel+=1;
        }

        friend ostream& operator<<(std::ostream& os, const ProdGenerico& p){
            string corchete = " [";
            string m3 = " m3]";
            string kg = " kg]\n";
            
            
            os << p.nombre() << corchete + to_string(p.get_volumen()) << m3 << corchete + to_string(p.get_peso()) << kg;
    
            return os;
        }
};
