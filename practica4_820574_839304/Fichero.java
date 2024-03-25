/*
* Fichero: Fichero.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 25/03/2024
*/

public class Fichero extends Nodo{
    
    protected double size;

    Fichero(String _name, Path _path, Nodo _parent, double _size)
    {
        super(_name, _path, _parent);
        size = _size;
    }

    @Override
    public double getSize()
    {
        return size;
    }

    public void setSize(double _size)
    {
        size = _size;
    }

}
