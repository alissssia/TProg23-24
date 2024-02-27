/*
* Fichero: Prog_suma.java
* Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
* Fecha: 27/02/2023
*/

public class Prog_suma extends Programa {
    public Prog_suma(){
        super(4);
        instrucciones[0] = new Read();
        instrucciones[1] = new Read();
        instrucciones[2] = new Add();
        instrucciones[3] = new Write();
    }
}
