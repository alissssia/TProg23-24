/*
* Fichero: Fichero.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 25/03/2024
*/

public class Fichero extends Nodo
{
    
    protected int size;

    Fichero(String _name, Directorio _parent, int _size)
    {
        super(_name, _parent);
        size = _size;
    }

    @Override
    public int getSize()
    {
        return size;
    }

    @Override
    public int getSize(int limit)
    {
        return size;
    }

    public void setSize(int _size)
    {
        size = _size;
    }

}
