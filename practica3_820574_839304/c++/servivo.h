/*
* Fichero: servivo.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
*/

#pragma once
#include "prodgenerico.h"

class SerVivo : public ProdGenerico{
    public:
        SerVivo(string _nombre, double _volumen, double _peso);
    
};