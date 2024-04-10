/*
* Fichero: Enlace.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 25/03/2024
*/

public class Enlace extends Nodo
{
    
    protected Nodo target;

    Enlace(String _name, Path _path, Nodo _target)
    {
        super(_name, _path);
        target = _target;
    }

    @Override
    public double getSize()
    {
        return target.getSize();
    }

    public Nodo getTarget() {
        return target;
    }

}