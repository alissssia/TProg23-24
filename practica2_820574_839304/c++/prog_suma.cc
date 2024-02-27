/*
* Fichero: prog_suma.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include "prog_suma.h"
#include "read.h"
#include "write.h"
#include "add.h"

Prog_Suma::Prog_Suma()
    : Programa(4)
{   
    instrucciones[0] = new Read();
    instrucciones[1] = new Read();
    instrucciones[2] = new Add();
    instrucciones[3] = new Write();
};