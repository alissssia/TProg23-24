package practica2_820574_839304.java;

public class Prog_suma extends Programa {
    public Prog_suma(){
        super(4);
        instrucciones[0] = new Read();
        instrucciones[1] = new Read();
        instrucciones[2] = new Add();
        instrucciones[3] = new Write();
    }
}
