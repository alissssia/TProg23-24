package practica2_820574_839304.java;

public class Read implements Instruccion {
    private String nombre;
    Read(){
        nombre = "read";
    }
    public void ejecutar(){
            
    }
    public String listar(){
        return nombre;
    }
}
