/*
* Fichero: toxico.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "prodgenerico.h"

class Toxico : public ProdGenerico{
    public:
        Toxico(string _nombre, double _volumen, double _peso)
            :ProdGenerico(_nombre, _volumen, _peso) {}
    
};