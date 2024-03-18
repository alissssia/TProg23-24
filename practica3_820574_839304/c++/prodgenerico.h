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
                    : Inventario(_volumen), peso(_peso)
        {
            name = _nombre;
        }

    public:
        double get_peso() const
        {
            return peso;
        }

        void aumentar_nivel()
        {
            nivel+=1;
        }

        virtual string descripcion() const
        {
            string resultado = this->nombre() + " [" + to_string(this->get_volumen()) + " m3] ["
                                + to_string(this->get_peso()) + " kg]\n";
            return resultado;
        }

        friend ostream& operator<<(std::ostream& os, const ProdGenerico& p){
            os << p.descripcion();
            return os;
        }
};
