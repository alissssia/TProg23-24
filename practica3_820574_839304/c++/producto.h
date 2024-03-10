/*
* Fichero: producto.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 09/03/2024
* Comentarios: este es el producto normal (no toxico ni ser vivo)
*/

#pragma once
#include "prodgenerico.h"
#include "carga.h"

class Producto : public ProdGenerico, public Carga{
    public:
        Producto(string _nombre, double _volumen,  double _peso);
    
};