/*
* Fichero: Shell.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 05/04/2024
*/

import java.util.Map;


public class Shell
{
    private Path cwdPath;
    private Directorio root;
    private Directorio cwd;


    Shell()
    {
        root = new Directorio("root", cwdPath, null);
        cwd = root;
        cwdPath = new Path("/");
    }

    public String pwd()
    {
        return cwd.getPath().getPathName();
    }

    public String ls()
    {
        String resList = new String();

        for(Map.Entry<String, Nodo> archivo : cwd.content.entrySet()){
            resList = resList + archivo.getKey() + "\n";
        }

        // quitamos el ultimo salto de linea
        if(resList.length() > 0)
        {
            resList.substring(0, resList.length() - 1);
        }

        return resList;
    }

    public String du()
    {
        String resList = new String();

        for(Map.Entry<String, Nodo> archivo : cwd.content.entrySet()){
            resList = resList + archivo.getKey() + "\t\t\t\t" + String.valueOf(archivo.getValue().getSize()) + "\n";
        }

        // quitamos el ultimo salto de linea
        if(resList.length() > 0)
        {
            resList.substring(0, resList.length() - 1);
        }

        return resList;
    }

    public void vi(String name, int size)
    {
        Fichero fich;

        if(cwd.contains(name))
        {
            fich = (Fichero) cwd.getItem(name);
            fich.setSize(size);
        }
        else 
        {
            fich = new Fichero(name, cwdPath.to(name), cwd, size);
            cwd.add(fich);
        }
    }

    public void mkdir(String name)
    {
        if(cwd.contains(name))
        {
            // excepcion
        }
        else
        {
            cwd.add(new Directorio(name, cwdPath.to(name), cwd));
        }
    }

    public void cd(String path)
    {
        if(path.equals("."))
        {
            // no hace nada? o añade '.' al pathName? preguntar
        }
        else if(path.equals(".."))
        {
            // solo nos lleva al padre? o añade '.' al pathName? preguntar
        }
        else
        {

        }
    }



}
