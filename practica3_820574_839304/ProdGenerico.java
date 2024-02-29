/*
* Fichero: ProdGenerico.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 29/02/2024
*/

public abstract class ProdGenerico extends Inventario{
    protected double peso;

    ProdGenerico(double _volumen, String _nombre, double _peso)
    {
        super(_volumen);
        nombre = _nombre;
        peso = _peso;
    }

    public double peso()
    {
        return peso;
    }

    @Override
    public String toString()
    {
        return nombre;
    }
}
