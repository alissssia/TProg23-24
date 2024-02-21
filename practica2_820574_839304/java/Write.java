package practica2_820574_839304.java;

public class Write implements Instruccion{
    private String nombre;
    Write(){
        nombre = "write";
    }
    public void ejecutar(){
            
    }
    public String listar(){
        return nombre;
    }
}
