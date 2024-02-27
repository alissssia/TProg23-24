/*
* Fichero: main.cc
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

#include "prog_suma.h"
#include "prog_cuenta_atras.h"
#include "prog_factorial.h"
#include <iostream>

// Programa principal
// Lista y ejecuta los 3 programas implementados, uno seguido de otro
int main(){
    Prog_Suma suma_exe;
    suma_exe.listar();
    suma_exe.run();
    
    cout <<endl;

    Prog_Cuenta_Atras cuenta_atras_exe;
    cuenta_atras_exe.listar();
    cuenta_atras_exe.run();

    cout << endl;
    
    Prog_Factorial factorial_exe;
    factorial_exe.listar();
    factorial_exe.run();

    return 0;
}
