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
            string str_peso = to_string(this->get_peso());
            while (str_peso[str_peso.size() - 1] == '0' || str_peso[str_peso.size() - 1] == '.') str_peso.resize(str_peso.size() - 1);
            
            string str_volumen = to_string(this->get_volumen());
            while (str_volumen[str_volumen.size() - 1] == '0' || str_volumen[str_volumen.size() - 1] == '.') str_volumen.resize(str_volumen.size() - 1);

            string resultado = this->nombre() + " [" + str_volumen + " m3] ["
                                + str_peso + " kg]\n";
            return resultado;
        }

        friend ostream& operator<<(std::ostream& os, const ProdGenerico& p){
            os << p.descripcion();
            return os;
        }
};
