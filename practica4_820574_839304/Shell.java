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
        
        
        if(strPath.equals("."))
        {
            // no hace nada
        }
        else if(strPath.equals("..")) // va al directorio anterior
        {
            cwd.pop();

            if(cwd.empty())     // siempre tiene que estar root como directorio base
            {
                cwd.push(root);
            }
            
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
            
            try {
                
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
            } catch (NoEsEnlaceNiDirectorio e) {
                System.out.println(e.getMessage());
            } catch (NoExisteObjetoEnEsaRuta e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
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
            if(path.isRootPath()) // si nos dan una ruta absoluta empezamos desde la raiz
            {
                dirActual = root;
            }
            else // si la ruta es relativa empezamos desde la cima de la pila
            {
                dirActual = cwd.peek();
            }

            while(path.hasMoreDirectories()) // mientras haya más directorios en el camino
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
            String targetName = path.getPathName();

            // Hemos llegado al directorio en el que se encuentra el ultimo objeto de la direccion pasada (dirActual)
            if(dirActual.contains(targetName))
            {
                Nodo target = dirActual.getItem(targetName); // se obtiene el objeto destino del enlace
                Enlace enlace = new Enlace(name, dirActual.getPath(), target); // se crea el enlace
                if(dirActual.contains(name))
                {
                    dirActual.add(enlace); // se añade el enlace al directorio
                }
                else
                {
                    throw new YaExisteEseNombre("Ya hay un nodo en la ruta con el nombre especificado: " + name);
                }
                
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
        

        Path ruta = new Path(path);
        Directorio dirActual, dirAnterior;

        if(ruta.isRootPath()) // si nos dan una ruta absoluta empezamos desde la raiz
        {
            dirActual = root;
        }
        else // si la ruta es relativa empezamos desde la cima de la pila
        {
            dirActual = cwd.peek();
        }

        try {

            while(ruta.hasMoreDirectories()) // mientras haya más directorios en el camino
            {
                String nextPathName = ruta.getFirstDirectory().getPathName();
                
                /*
                if(nextPathName == ".")
                {
                    // no hace nada
                }
                else if (nextPathName == "..")
                {
                    dirActual = dirAnterior;
                }
                else 
                */
                if (dirActual.contains(nextPathName))
                {
                    if(dirActual.getItem(nextPathName) instanceof Directorio)
                    {
                        dirAnterior = dirActual;

                        dirActual = (Directorio) dirActual.getItem(nextPathName);
                    }
                    else if(dirActual.getItem(nextPathName) instanceof Enlace)
                    {
                        dirAnterior = dirActual;

                        Enlace enlace = (Enlace) dirActual.getItem(nextPathName);
                        dirActual = (Directorio) enlace.getTarget();
                    }
                    else
                    {
                        throw new NoEsEnlaceNiDirectorio("El objeto especificado no es ni enlace ni directorio: " + dirActual.getItem(nextPathName));
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
            if(!dirActual.contains(targetName))
            {
                throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + path);
            }
            
            return dirActual.getItem(targetName).getSize();
            
        } catch (NoEsEnlaceNiDirectorio e) {
            System.out.println(e.getMessage());
            
        } catch (NoExisteObjetoEnEsaRuta e) {
            System.out.println(e.getMessage());
        } catch (Exception e) { 
            System.out.println(e.getMessage()); 
        }

        return 0;
    }



    public void rm (String path) {
        
                
        Path rutaHastaNodo = new Path(path);
        Directorio dirActual;

        if(rutaHastaNodo.isRootPath()) // si nos dan una ruta absoluta empezamos desde la raiz
        {
            dirActual = root;
        }
        else // si la ruta es relativa empezamos desde la cima de la pila
        {
            dirActual = cwd.peek();
        }

        try {

            while(rutaHastaNodo.hasMoreDirectories()) // mientras haya más directorios en el camino
            {
                String pathName = rutaHastaNodo.getFirstDirectory().getPathName();
    
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
                    
                rutaHastaNodo.removeFirstDirectory();

                /*
                // comprobar si el elemento a eliminar es un directorio o enlace que forma parte del path al directorio activo
                if (!rutaActual.getPathName().contains(dirActual.getPath().getPathName()) && !directorioSalvado) {
                    aSalvoDeBorrar = dirActual;
                    directorioSalvado = true;
                }
                */
            }
            
            // Hemos llegado al directorio en el que se encuentra el ultimo objeto de la direccion pasada (dirActual)
            String targetName = rutaHastaNodo.getPathName();

            if(!dirActual.contains(targetName))
            {
                throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + path);
            }
            else
            {
                if(dirActual.getItem(targetName) instanceof Fichero)
                {
                    dirActual.remove(targetName);
                }
                else // Directorio o enlace
                {
                    Nodo nodoAEliminar = dirActual.getItem(targetName);
                    moverADirectorioSeguroMasProximo(nodoAEliminar);
                    
                    if(nodoAEliminar instanceof Enlace)
                    {
                        dirActual.remove(targetName);
                    }
                    else // Directorio
                    {
                        Directorio dirAEliminar = (Directorio) nodoAEliminar;

                        dirAEliminar.clearItems();
                        dirActual.remove(targetName);
                    }
                }
            }
    
        } catch (NoExisteObjetoEnEsaRuta e) {
            System.out.println(e.getMessage());
               
        } catch (NoEsEnlaceNiDirectorio e){
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    


    // -----------------------------------------------------------------------------------

    

    private void returnToRootDir()
    {
        cwd.clear();
        cwd.add(root);
    }
    

    private int getSizeWithLimit(Nodo nodo, int limit) {
        if (limit <= 0) {
            return 0; // Si se alcanza el límite de iteraciones, se devuelve 0
        }

        if (nodo instanceof Enlace) {
            Enlace enlace = (Enlace) nodo;
            return getSizeWithLimit(enlace.getTarget(), limit - 1); // Reducir el límite en 1 y continuar la recursión
        } else {
            return (int) nodo.getSize(); // Si no es un enlace, se devuelve el tamaño normal del nodo
        }
    }



    // post: la cima del cwd cuando acaba la función contiene nodoAEliminar
    //          y es el único elemento del la pila cwd que lo contiene
    private void moverADirectorioSeguroMasProximo(Nodo nodoAEliminar)
    {
        Stack<Directorio> colaAuxiliar = new Stack<Directorio>();
        boolean enlace = (nodoAEliminar instanceof Enlace);
        
        // metemos todos los directorios de cwd en 'orden inverso' en colaAuxiliar
        while(!cwd.empty()) 
        {
            colaAuxiliar.add(cwd.pop());
        }

        boolean seguir = true;
        // comprobamos que los directorios por los que vamos pasando no contengan el nodoAEliminar
        // si no lo contiene, lo volvemos a añadir a cwd. si lo contiene, hemos llegado al directorio seguro
        
        if(enlace)
        {
            while(!colaAuxiliar.isEmpty() && seguir)
            {
                if(colaAuxiliar.peek().contains(nodoAEliminar))
                {
                    seguir = false;
                }

                cwd.add(colaAuxiliar.pop());
            }

            
            

        }
        else // Directorio
        {
            while(!colaAuxiliar.isEmpty() && seguir)
            {
                // si el siguiente directorio a introducir al cwd es el directorio a eliminar,
                // paramos (nos quedamos en el inmediatamente anterior)
                if(colaAuxiliar.peek().equals(nodoAEliminar))
                {
                    seguir = false;
                }
                else    // si no lo es, lo introducimos al cwd
                {
                    cwd.add(colaAuxiliar.pop());
                }
            }
        }
    }
}
