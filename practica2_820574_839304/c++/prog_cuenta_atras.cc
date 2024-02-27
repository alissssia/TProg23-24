/*
* Fichero: prog_cuenta_atras.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include "prog_cuenta_atras.h"
#include "read.h"
#include "write.h"
#include "add.h"
#include "dup.h"
#include "push.h"
#include "jump_if.h"

Prog_Cuenta_Atras::Prog_Cuenta_Atras()
    : Programa(7)
{
    instrucciones[0] = new Read();
    instrucciones[1] = new Dup();
    instrucciones[2] = new Write();
    instrucciones[3] = new Push(-1);
    instrucciones[4] = new Add();
    instrucciones[5] = new Dup();
    instrucciones[6] = new Jump_If(1);
};