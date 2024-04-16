/*
* Fichero: Directorio.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 25/03/2024
*/

import java.util.HashMap;
import java.util.Map;


public class Directorio extends Nodo
{
    
    public Map<String, Nodo> content;
    
    Directorio(String _name, Directorio _parent)
    {
        super(_name, _parent);
        content = new HashMap<>();
    }

    Directorio(Directorio _dir)
    {
        super(_dir);
        content = new HashMap<>();
    }

    @Override
    public int getSize() {
        int res = getSize(15);

        if(res == -1) // Error
        {
            return 0;
        }
        else
        {
            return res;
        }


        /*
        int res = 0;

        
        for(Map.Entry<String, Nodo> archivo : content.entrySet()){
            res += archivo.getValue().getSize();
        }

        return res;
        */
    }

    public int getSize(int limit) {

        if(limit <= 0)
        {
            return -1;
        }

        int total = 0;
        int res = 0;

        for(Map.Entry<String, Nodo> archivo : content.entrySet()){
            res = archivo.getValue().getSize(limit-1);

            if(res == -1)
            {
                return res;
            }
            else
            {
                total += res;
            }
        }

        return total;
    }

    public void add(Nodo n)
    {
        content.put(n.name, n);
    }

    public void remove(String s)
    {
        content.remove(s);
    }

    public boolean contains(String s)
    {
        return content.containsKey(s);
    }

    public boolean contains(Nodo n)
    {
        return (contains(n.name) && getItem(n.name).equals(n));
    }

    public Nodo getItem(String s)
    {
        return content.get(s);
    }

    public void clearItems()
    {
        content.clear();
    }

}