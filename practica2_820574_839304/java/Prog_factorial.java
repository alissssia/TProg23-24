/*
* Fichero: Prog_factorial.java
* Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
* Fecha: 27/02/2023
*/

public class Prog_factorial extends Programa {
    public Prog_factorial() {
        super(14);
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
    }
}