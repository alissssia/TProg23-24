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
        root = new Directorio(root);
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
            resList += archivo.getKey() + "\t" + String.valueOf(getSizeWithLimit(archivo.getValue(), controlBuclesInfinitos)) + "\n";
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
            try {
                if(new Path(name).hasMoreDirectories())
                {
                    throw new NombreFicheroNoValido("Nombre de directorio no válido, contiene '/': " + name);
                }

                fich = new Fichero(name, cwd.peek(), size);
                cwd.peek().add(fich);
            }
            catch(NombreFicheroNoValido e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void mkdir(String name)
    {
        try {

            if(new Path(name).hasMoreDirectories())
            {
                throw new NombreDirectorioNoValido("Nombre de directorio no válido, contiene '/': " + name);
            }
            else if(cwd.contains(name))
            {
                throw new YaExisteEseNombre("Ya existe un objeto con ese nombre: " + name);
            }
            else
            {
                cwd.peek().add(new Directorio(name, cwd.peek()));
            }

        } catch (NombreDirectorioNoValido e) {
            System.out.println(e.getMessage());
        } catch (YaExisteEseNombre e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public void cd(String strPath)
    {
        Path path = new Path(strPath);
        Directorio dirActual;

        try {
            if(path.endsWithBar())
            {
                throw new NombreRutaNoValido("El camino especificado no es válido porque termina en '/': " + strPath);
            }
            else if(path.hasDoubleBar())
            {
                throw new NombreRutaNoValido("El camino especificado no es válido porque contiene '//': " + strPath);
            }


            if(path.isRootPath()) //si nos dan una ruta absoluta empezamos desde la raiz
            {
                returnToRootDir();
                path.removeRootBar();
            }
            
            dirActual = cwd.peek();
            
            while(!path.getPathName().equals(""))
            {
                String nextPathName = path.getFirstDirectory();

                if(nextPathName.equals("."))
                {
                    // no hace nada
                } 
                else if (nextPathName.equals(".."))
                {
                    goBackIfPossible(cwd);
                }
                else if(dirActual.contains(nextPathName)) // si el directorio actual contiene el siguiente directorio en el camino
                {
                    if(dirActual.getItem(nextPathName) instanceof Directorio) // si el siguiente directorio es un directorio
                    {
                        cwd.push((Directorio) dirActual.getItem(nextPathName));
                    }
                    else if(dirActual.getItem(nextPathName) instanceof Enlace) // si el siguiente directorio es un enlace
                    {
                        Enlace enlace = (Enlace) dirActual.getItem(nextPathName);
                        if(enlace.getTarget() instanceof Directorio)
                        {
                            cwd.add((Directorio) enlace.getTarget());
                        }
                        else
                        {
                            throw new TargetNoEsDirectorio("El target del enlace no es un directorio: " + nextPathName);
                        }
                    }
                    else
                    {
                        throw new NoEsEnlaceNiDirectorio("El objeto especificado no es ni enlace ni directorio: " + dirActual.getItem(nextPathName));
                    }
                }
                else
                {
                    throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + strPath);
                }
                
                path.removeFirstDirectory();
                dirActual = cwd.peek();
            
            }
        } catch (TargetNoEsDirectorio e) {
            System.out.println(e.getMessage());
        } catch (NoEsEnlaceNiDirectorio e) {
            System.out.println(e.getMessage());
        } catch (NoExisteObjetoEnEsaRuta e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    




    public void ln(String strPath, String name)        // EXCEPCION: nombre ya existe en directorio
    {
        Directorio dirActual;
        Path path = new Path(strPath);

        Stack<Directorio> cwdCopy = new Stack<Directorio>();
        cwdCopy.addAll(cwd);

        try {

            if(path.endsWithBar())
            {
                throw new NombreRutaNoValido("El camino especificado no es válido porque termina en '/': " + strPath);
            }
            else if(path.hasDoubleBar())
            {
                throw new NombreRutaNoValido("El camino especificado no es válido porque contiene '//': " + strPath);
            }
            else if(new Path(name).hasMoreDirectories())
            {
                throw new NombreEnlaceNoValido("Nombre no válido: " + name);
            }



            if(path.isRootPath()) // si nos dan una ruta absoluta empezamos desde la raiz
            {
                cwdCopy.clear();
                cwdCopy.add(root);
                path.removeRootBar();
            }
            
            dirActual = cwdCopy.peek();

            while(path.hasMoreDirectories()) // mientras haya más directorios en el camino
            {
                String nextPathName = path.getFirstDirectory();

                if(nextPathName.equals("."))
                {
                    // no hace nada
                }
                else if(nextPathName.equals(".."))
                {
                    goBackIfPossible(cwdCopy);
                }
                else if(dirActual.contains(nextPathName))
                {

                    if(dirActual.getItem(nextPathName) instanceof Directorio)
                    {
                        cwdCopy.add((Directorio) dirActual.getItem(nextPathName));
                    }
                    else if(dirActual.getItem(nextPathName) instanceof Enlace)
                    {
                        Enlace enlace = (Enlace) dirActual.getItem(nextPathName);
                        if(enlace.getTarget() instanceof Directorio)
                        {
                            cwdCopy.add((Directorio) enlace.getTarget());
                        }
                        else
                        {
                            throw new TargetNoEsDirectorio("El target del enlace no es un directorio: " + nextPathName);
                        }
                    }
                    else
                    {
                        throw new NoEsEnlaceNiDirectorio("El objeto especificado no es ni enlace ni directorio: " + dirActual.getItem(nextPathName));
                    }
                }
                else
                {
                    throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + strPath);
                }
                
                dirActual = cwdCopy.peek();
                path.removeFirstDirectory();
            }

            String targetName = path.getPathName();
            path = new Path(strPath);

            // Hemos llegado al directorio en el que se encuentra el ultimo objeto de la direccion pasada (dirActual)
            if(dirActual.contains(targetName))
            {

                Nodo target = dirActual.getItem(targetName); // se obtiene el objeto destino del enlace
                Enlace enlace = new Enlace(name, cwd.peek(), target); // se crea el enlace

                if(!cwd.peek().contains(name))
                {
                    cwd.peek().add(enlace); // se añade el enlace al directorio actual
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
        } catch (TargetNoEsDirectorio e) {
            System.out.println(e.getMessage());
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
    int stat (String strPath)
    {
        Path path = new Path(strPath);
        Directorio dirActual;

        Stack<Directorio> cwdCopy = new Stack<Directorio>();
        cwdCopy.addAll(cwd);

        try {

            if(path.endsWithBar())
            {
                throw new NombreRutaNoValido("El camino especificado no es válido porque termina en '/': " + strPath);
            }
            else if(path.hasDoubleBar())
            {
                throw new NombreRutaNoValido("El camino especificado no es válido porque contiene '//': " + strPath);
            }


            if(path.isRootPath()) // si nos dan una ruta absoluta empezamos desde la raiz
            {   
                cwdCopy.clear();
                cwdCopy.add(root);
                path.removeRootBar();
            }
            
            dirActual = cwdCopy.peek();

            while(path.hasMoreDirectories()) // mientras haya más directorios en el camino
            {
                String nextPathName = path.getFirstDirectory();
                
                if(nextPathName.equals("."))
                {
                    // no hace nada
                }
                else if(nextPathName.equals(".."))
                {
                    goBackIfPossible(cwdCopy);
                }
                if (dirActual.contains(nextPathName))
                {
                    if(dirActual.getItem(nextPathName) instanceof Directorio)
                    {
                        cwdCopy.add((Directorio) dirActual.getItem(nextPathName));

                    }
                    else if(dirActual.getItem(nextPathName) instanceof Enlace)
                    {
                        Enlace enlace = (Enlace) dirActual.getItem(nextPathName);
                        if(enlace.getTarget() instanceof Directorio)
                        {
                            cwdCopy.add((Directorio) enlace.getTarget());
                        }
                        else
                        {
                            throw new TargetNoEsDirectorio("El target del enlace no es un directorio: " + nextPathName);
                        }
                    }
                    else
                    {
                        throw new NoEsEnlaceNiDirectorio("El objeto especificado no es ni enlace ni directorio: " + dirActual.getItem(nextPathName));
                    }
                }
                else
                {
                    throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + strPath);
                }
                
                dirActual = cwdCopy.peek();
                path.removeFirstDirectory();
            }

            String targetName = path.getLastDirectory().getPathName();

            // Hemos llegado al directorio en el que se encuentra el ultimo objeto de la direccion pasada (dirActual)
            if(!dirActual.contains(targetName))
            {
                throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + strPath);
            }
            
            return dirActual.getItem(targetName).getSize();

        } catch (TargetNoEsDirectorio e) {
            System.out.println(e.getMessage());
            
        } catch (NoEsEnlaceNiDirectorio e) {
            System.out.println(e.getMessage());

        } catch (NoExisteObjetoEnEsaRuta e) {
            System.out.println(e.getMessage());
            
        } catch (Exception e) { 
            System.out.println(e.getMessage()); 
        }

        return 0;
    }



    public void rm (String strPath) {
        
                
        Path rutaHastaNodo = new Path(strPath);
        Directorio dirActual;

        Stack<Directorio> cwdCopy = new Stack<Directorio>();
        cwdCopy.addAll(cwd);

        try {

            if(rutaHastaNodo.endsWithBar())
            {
                throw new NombreRutaNoValido("El camino especificado no es válido porque termina en '/': " + strPath);
            }
            else if(rutaHastaNodo.hasDoubleBar())
            {
                throw new NombreRutaNoValido("El camino especificado no es válido porque contiene '//': " + strPath);
            }


            if(rutaHastaNodo.isRootPath()) // si nos dan una ruta absoluta empezamos desde la raiz
            {
                cwdCopy.clear();
                cwdCopy.add(root);
                rutaHastaNodo.removeRootBar();
            }
            
            dirActual = cwdCopy.peek();

            while(rutaHastaNodo.hasMoreDirectories()) // mientras haya más directorios en el camino
            {
                String nextPathName = rutaHastaNodo.getFirstDirectory();
    
                if(dirActual.contains(nextPathName))
                {
                    if(dirActual.getItem(nextPathName) instanceof Directorio)
                    {
                        cwdCopy.add((Directorio) dirActual.getItem(nextPathName));
                    }
                    else if(dirActual.getItem(nextPathName) instanceof Enlace)
                    {
                        Enlace enlace = (Enlace) dirActual.getItem(nextPathName);
                        if(enlace.getTarget() instanceof Directorio)
                        {
                            cwdCopy.add((Directorio) enlace.getTarget());
                        }
                        else
                        {
                            throw new TargetNoEsDirectorio("El target del enlace no es un directorio: " + nextPathName);
                        }
                    }
                    else
                    {
                        throw new NoEsEnlaceNiDirectorio("El objeto especificado no es ni enlace ni directorio: " + dirActual.getItem(nextPathName));
                    }
                }
                else
                {
                    throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + strPath);
                }
                
                dirActual = cwdCopy.peek();
                rutaHastaNodo.removeFirstDirectory();
            }
            
            // Hemos llegado al directorio en el que se encuentra el ultimo objeto de la direccion pasada (dirActual)
            String targetName = rutaHastaNodo.getPathName();

            if(!dirActual.contains(targetName))
            {
                throw new NoExisteObjetoEnEsaRuta("El camino especificado no existe: " + strPath);
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

        } catch (TargetNoEsDirectorio e) {
            System.out.println(e.getMessage());

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

    private void goBackIfPossible(Stack<Directorio> stack)
    {
        stack.pop();
    
        if(stack.empty())
        {
            stack.push(root);      // siempre tiene que haber mínimo un directorio root como base de la pila
        }
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
