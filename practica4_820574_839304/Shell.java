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

    public String pwd() // no necesita excepciones
    {
        return cwd.peek().getPath().getPathName();
    }

    public String ls() // no necesita excepciones
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

    public String du() // hay que controlar el tamaño de los enlaces por si acaso se va alv
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

    public void vi(String name, int size) // no necesita excepciones 
    {
        Fichero fich;

        if(cwd.contains(name)) // si existe el fichero
        {
            fich = (Fichero) cwd.peek().getItem(name);
            fich.setSize(size);
        }
        else // si no existe se crea con ese tamaño
        {
            fich = new Fichero(name, cwd.peek().getPath().to(name), size);
            cwd.peek().add(fich);
        }
    }

    public void mkdir(String name)
    {
        if(cwd.contains(name))
        {
            // excepcion ya existe un objeto con ese nombre
        }
        else
        {
            cwd.peek().add(new Directorio(name, cwd.peek().getPath().to(name)));
        }
    }

    public void cd(String strPath)
    {
        try {
        
            if(strPath.equals("."))
            {
                // no hace nada
            }
            else if(strPath.equals("..")) // va al directorio padre
            {
                cwd.pop();
            }
            else 
            {
                Path path = new Path(strPath);
                Directorio dirActual;

                if(path.isRootPath()) //si nos dan una ruta absoluta empezamos desde la raiz
                {
                    returnToRootDir();
                    dirActual = root;
                }
                else // si la ruta es relativa empezamos desde la cima de la pila
                {
                    dirActual = cwd.peek();
                }
                
                
                while(!path.getPathName().equals(""))
                {
                    String pathName = path.getFirstDirectory().getPathName();
                    if(dirActual.contains(pathName)) // si el directorio actual contiene el siguiente directorio en el camino
                    {
                        if(dirActual.getItem(pathName) instanceof Directorio) // si el siguiente directorio es un directorio
                        {
                            cwd.push((Directorio) dirActual.getItem(pathName));
                        }
                        else if(dirActual.getItem(pathName) instanceof Enlace) // si el siguiente directorio es un enlace
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
        catch () {
            // excepcion no es ni enlace ni directorio
        } catch (NoExisteObjetoEnEsaRuta e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
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
            if(path.isRootPath()) // si nos dan una ruta absoluta empezamos desde la raiz
            {
                dirActual = root;
            }
            else // si la ruta es relativa empezamos desde la cima de la pila
            {
                dirActual = cwd.peek();
            }

            while(path.getPathName().contains("/")) // mientras haya más directorios en el camino
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
                Nodo target = dirActual.getItem(targetName); // se obtiene el objeto destino del enlace
                Enlace enlace = new Enlace(name, dirActual.getPath(), target); // se crea el enlace
                dirActual.add(enlace); // se añade el enlace al directorio
            }
            else
            {
                throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + strPath);
            }

        } catch (NombreEnlaceNoValido e) {
            e.printStackTrace();
        } catch () {
            // excepcion no es ni enlace ni directorio
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

            Path ruta = new Path(path);
            Directorio dirActual;

            if(ruta.isRootPath()) // si nos dan una ruta absoluta empezamos desde la raiz
            {
                dirActual = root;
            }
            else // si la ruta es relativa empezamos desde la cima de la pila
            {
                dirActual = cwd.peek();
            }

            while(ruta.getPathName().contains("/")) // mientras haya más directorios en el camino
            {
                String pathName = ruta.getFirstDirectory().getPathName();

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
                    throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + path);
                }
                
                ruta.removeFirstDirectory();
            }

            String targetName = ruta.getLastDirectory().getPathName();
            // Hemos llegado al directorio en el que se encuentra el ultimo objeto de la direccion pasada (dirActual)
            if(dirActual.contains(targetName))
            {
                return dirActual.getItem(targetName).getSize();
            }
            else
            {
                throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + path);
            }

        } catch (NoExisteObjetoEnEsaRuta e) {
            e.printStackTrace();
            
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
