package practica2_820574_839304.java;

public class Prog_cuenta_atras extends Programa {
    public Prog_cuenta_atras(){
        super(7);
        instrucciones[0] = new Read();
        instrucciones[1] = new Dup();
        instrucciones[2] = new Write();
        instrucciones[3] = new Push(-1);
        instrucciones[4] = new Add();
        instrucciones[5] = new Dup();
        instrucciones[6] = new Jump_If(1);
    }
}
