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
    
    Directorio(String _name, Path _path, Nodo _parent)
    {
        super(_name, _path, _parent);
        content = new HashMap<>();
    }

    @Override
    public double getSize() {
        double res = 0;
        
        int maxLevels = 10; // límite de niveles para evitar bucles infinitos

        
        // CUIDADO: llevar cuenta (de alguna forma) de cuantos niveles hemos recorrido
        // por si hay bucles provocados por enlaces que darían size infinito
        for(Map.Entry<String, Nodo> archivo : content.entrySet()){
            res += archivo.getValue().getSize();
        }

        return res;
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

    public Nodo getItem(String s)
    {
        return content.get(s);
    }

}