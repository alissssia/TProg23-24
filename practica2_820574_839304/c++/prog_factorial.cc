#include "prog_factorial.h"
#include "read.h"
#include "write.h"
#include "add.h"
#include "dup.h"
#include "push.h"
#include "jump_if.h"
#include "mul.h"
#include "swap.h"
#include "over.h"

Prog_Factorial::Prog_Factorial()
    : Programa(14)
{
    instrucciones[0] = new Push(1);
    instrucciones[1] = new Read();
    instrucciones[2] = new Swap();
    instrucciones[3] = new Over();
    instrucciones[4] = new Mul();
    instrucciones[5] = new Swap();
    instrucciones[6] = new Push(-1);
    instrucciones[7] = new Add();
    instrucciones[8] = new Dup();
    instrucciones[9] = new Push(-2);
    instrucciones[10] = new Add();
    instrucciones[11] = new Jump_If(2);
    instrucciones[12] = new Swap();
    instrucciones[13] = new Write();
};
