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
        int res = target.getSize(15);

        if(res == -1) // Error
        {
            return 0;
        }
        else
        {
            return res;
        }
    }
    
    @Override
    public int getSize(int limit)
    {
        if(limit <= 0)
        {
            return -1;
        }

        return target.getSize(limit-1);
    }

    public Nodo getTarget() {
        return target;
    }

}