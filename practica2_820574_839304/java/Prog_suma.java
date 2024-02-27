/*
* Fichero: Prog_suma.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 27/02/2023
*/

/* 
* Clase heredada de Programa
* Ejecuta una serie de instrucciones que muestran por pantalla la
* suma de dos numeros introducidos por el usuario
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
