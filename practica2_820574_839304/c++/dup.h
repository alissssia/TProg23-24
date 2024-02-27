/*
* Fichero: dup.h
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/
#pragma once
#include "instruccion.h"

// Clase heredada de Instruccion
class Dup : public Instruccion {
    
    public:
        // Constructor: inicializa el nombre de la instruccion
        Dup();


        // Metodo: Extrae el primer elemento de la pila, lo inserta dos veces y aumenta el pc en 1
        void ejecutar(stack<int> &pila, int &pc) override;

};
