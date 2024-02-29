/*
* Fichero: Inventario.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 29/02/2024
*/

abstract class Inventario
{
    protected String nombre;
    protected double volumen;

    Inventario(double _volumen)
    {
        volumen = _volumen;
    }

    public String nombre()
    {
        return nombre;
    }

    public double volumen()
    {
        return volumen;
    }

    abstract public double peso();

    abstract public String toString();
}