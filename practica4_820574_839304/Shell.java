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

    public String du() {
        String resList = "";
        int controlBuclesInfinitos = 15; // Límite de iteraciones para evitar bucles infinitos

        for (Map.Entry<String, Nodo> archivo : cwd.peek().content.entrySet()) {
            resList += archivo.getKey() + "\t\t\t\t" + String.valueOf(getSizeWithLimit(archivo.getValue(), controlBuclesInfinitos)) + "\n";
        }

         // quitamos el ultimo salto de linea
        if(resList.length() > 0)
        {
            resList.substring(0, resList.length() - 1);
        }

        return resList;
    }

    private int getSizeWithLimit(Nodo nodo, int limit) {
        if (limit <= 0) {
            return 0; // Si se alcanza el límite de iteraciones, se devuelve 0
        }

        if (nodo instanceof Enlace) {
            Enlace enlace = (Enlace) nodo;
            return getSizeWithLimit(enlace.getTarget(), limit - 1); // Reducir el límite en 1 y continuar la recursión
        } else {
            return nodo.getSize(); // Si no es un enlace, se devuelve el tamaño normal del nodo
        }
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
        try {
            if(cwd.contains(name))
            {
                throw new YaExisteEseNombre("Ya existe un objeto con ese nombre: " + name);
            }
            else
            {
                cwd.peek().add(new Directorio(name, cwd.peek().getPath().to(name)));
            }
        }
        catch (YaExisteEseNombre e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
                            throw new NoEsEnlaceNiDirectorio("El objeto especificado no es ni enlace ni directorio: " + dirActual.getItem(pathName));
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
        catch (NoEsEnlaceNiDirectorio e) {
            System.out.println(e.getMessage());
        } catch (NoExisteObjetoEnEsaRuta e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
                        throw new NoEsEnlaceNiDirectorio("El objeto especificado no es ni enlace ni directorio: " + dirActual.getItem(pathName));
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
            System.out.println(e.getMessage());
        } catch (NoEsEnlaceNiDirectorio e) {
            System.out.println(e.getMessage());
        } catch (NoExisteObjetoEnEsaRuta e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
                        throw new NoEsEnlaceNiDirectorio("El objeto especificado no es ni enlace ni directorio: " + dirActual.getItem(pathName));
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

        } catch (NoEsEnlaceNiDirectorio e) {
            System.out.println(e.getMessage());
            
        } catch (NoExisteObjetoEnEsaRuta e) {
            System.out.println(e.getMessage());
        } catch (Exception e) { 
            System.out.println(e.getMessage()); 
        }
    }

    public void rm (String path) {
        boolean directorioSalvado = false; // para controlar si el directorio a salvar ya ha sido encontrado
        Directorio aSalvoDeBorrar = null;

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
    
            Path rutaActual = cwd.peek().getPath();

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
                        throw new NoEsEnlaceNiDirectorio("El objeto especificado no es ni enlace ni directorio: " + dirActual.getItem(pathName));
                    }
                }
                else
                {
                    throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + path);
                }
                    
                ruta.removeFirstDirectory();

                // comprobar si el elemento a eliminar es un directorio o enlace que forma parte del path al directorio activo
                if (rutaActual.contains(dirActual.getPath()) && !directorioSalvado) {
                    aSalvoDeBorrar = dirActual;
                    directorioSalvado = true;
                }
            }
    
            String targetName = ruta.getLastDirectory().getPathName();
            // Hemos llegado al directorio en el que se encuentra el ultimo objeto de la direccion pasada (dirActual)

            if(dirActual.contains(targetName))
            {
                // si el objeto a borrar es un directorio y forma parte del path al directorio activo
                if (dirActual.getItem(targetName) instanceof Directorio && directorioSalvado) {
                    // se mueve el directorio activo al padre de aSalvoDeBorrar
                    cwd.clear();
                    cwd.push(aSalvoDeBorrar.getParent().getPath());
                    // se elimina el directorio a borrar
                    dirActual.remove(targetName);
                }
                
            }
            else
            {
                throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + path);
            }
    
        } catch (NoExisteObjetoEnEsaRuta e) {
            System.out.println(e.getMessage());
               
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void returnToRootDir()
    {
        cwd.clear();
        cwd.push(root);
    }
}
