/*
* Fichero: Shell.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 05/04/2024
*/

import java.util.Map;
import java.util.Stack;



public class Shell
{
    private Stack<Directorio> cwd;
    private Directorio root;


    Shell()
    {
        root = new Directorio("root", new Path("/"));
        cwd = new Stack<Directorio>();
        cwd.push(root);
    }

    public String pwd()
    {
        return cwd.peek().getPath().getPathName();
    }

    public String ls()
    {
        String resList = new String();

        for(Map.Entry<String, Nodo> archivo : cwd.peek().content.entrySet()){
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

        for(Map.Entry<String, Nodo> archivo : cwd.peek().content.entrySet()){
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
            fich = (Fichero) cwd.peek().getItem(name);
            fich.setSize(size);
        }
        else 
        {
            fich = new Fichero(name, cwd.peek().getPath().to(name), size);
            cwd.peek().add(fich);
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
            cwd.peek().add(new Directorio(name, cwd.peek().getPath().to(name)));
        }
    }

    public void cd(String strPath)
    {
        if(strPath.equals("."))
        {
            // no hace nada
        }
        else if(strPath.equals(".."))
        {
            cwd.pop();
        }
        else 
        {
            Path path = new Path(strPath);
            Directorio dirActual;

            if(path.isRootPath())
            {
                returnToRootDir();
                dirActual = root;
            }
            else
            {
                dirActual = cwd.peek();
            }
            
             
            while(!path.getPathName().equals(""))
            {
                String pathName = path.getFirstDirectory().getPathName();
                if(dirActual.contains(pathName))
                {
                    if(dirActual.getItem(pathName) instanceof Directorio)
                    {
                        cwd.push((Directorio) dirActual.getItem(pathName));
                    }
                    else if(dirActual.getItem(pathName) instanceof Enlace)
                    {
                        Enlace enlace = (Enlace) dirActual.getItem(pathName);
                        cwd.push((Directorio) enlace.getTarget());
                    }
                    else
                    {
                        // EXCEPCIÓN no es ni enlace ni directorio
                    }
                }
                else
                {
                    throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + strPath);
                }
                
                path.removeFirstDirectory();
                dirActual = cwd.peek();
            
            }
        }
    }

    public void ln(String strPath, String name)        // EXCEPCION: nombre ya existe en directorio
    {
        try {
            if (name.contains("/")) {
                throw new NombreEnlaceNoValido("Nombre no válido: " + name);
            }
            

            Directorio dirActual;

            Path path = new Path(strPath);
            if(path.isRootPath())
            {
                dirActual = root;
            }
            else
            {
                dirActual = cwd.peek();
            }

            while(path.getPathName().contains("/"))
            {
                String pathName = path.getFirstDirectory().getPathName();

                if(dirActual.contains(pathName))
                {
                    if(dirActual.getItem(pathName) instanceof Directorio)
                    {
                        dirActual = (Directorio) dirActual.getItem(pathName);
                    }
                    else if(dirActual.getItem(pathName) instanceof Enlace)
                    {
                        Enlace enlace = (Enlace) dirActual.getItem(pathName);
                        dirActual = (Directorio) enlace.getTarget();
                    }
                    else
                    {
                        // EXCEPCIÓN no es ni enlace ni directorio
                    }
                }
                else
                {
                    throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + strPath);
                }
                
                path.removeFirstDirectory();
            }

            path = new Path(strPath);
            String targetName = path.getLastDirectory().getPathName();
            // Hemos llegado al directorio en el que se encuentra el ultimo objeto de la direccion pasada (dirActual)
            if(dirActual.contains(targetName))
            {
                Nodo target = dirActual.getItem(targetName);
                Enlace enlace = new Enlace(name, dirActual.getPath(), target);
                dirActual.add(enlace);
            }
            else
            {
                throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + strPath);
            }

        } catch (NombreEnlaceNoValido e) {
            e.printStackTrace();
        } catch (NoExisteObjetoEnEsaRuta e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    // Devuelve el tamaño del nodo que referencia el path
    double stat (String path) 
    {
        try {
            if (/* path no valido porque no existe ese objeto */) {
                throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + path);
            }
            /* idk what i'm doing, coger muy con pinzas */
            Nodo nodo = cwd.peek().getItem(path);
            return nodo.getSize();
            
        } catch (NoExisteObjetoEnEsaRuta e) {
            e.printStackTrace();
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
    }

    public void rm (String path) {
 

        try {
            if (/* path no valido porque no existe ese objeto */) {
                throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + path);
            }

            Path ruta = new Path(path);
            
            /*
            // si vamos a borrar el directorio en el que nos encontramos
            if (path.equals(cwd.peek().getPath().getPathName())) { 
                Path nuevaRuta = cwd.peek().setPath(ruta.back());
            }
            cwd.remove(path);
            cwd.setPath(nuevaRuta);
            */

        } catch (NoExisteObjetoEnEsaRuta e) {
            e.printStackTrace();
        }



    }

    private void returnToRootDir()
    {
        cwd.clear();
        cwd.push(root);
    }
}
