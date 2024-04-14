/*
* Fichero: Enlace.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 25/03/2024
*/

public class Enlace extends Nodo
{
    
    protected Nodo target;

    Enlace(String _name, Directorio _parent, Nodo _target)
    {
        super(_name, _parent);
        target = _target;
    }

    @Override
    public int getSize()
    {
        return target.getSize();
    }

    public Nodo getTarget() {
        return target;
    }

}