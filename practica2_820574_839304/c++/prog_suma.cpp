#include "prog_suma.h"
#include "read.h"
#include "write.h"
#include "add.h"

using InstruccionPt = Instruccion*;

Prog_Suma::Prog_Suma()
    : Programa(4)
{   
    instrucciones[0] = new Read();
    instrucciones[1] = new Read();
    instrucciones[2] = new Add();
    instrucciones[3] = new Write();
}