/*
* Fichero: pathName.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 25/03/2024
*/

public class Path
{
    private String pathName;

    Path(String _pathName)
    {
        pathName = _pathName;
    }


    public void setPathName(String pathName)
    {
        this.pathName = pathName;
    }

    public String getPathName()
    {
        return pathName;
    }

    public String toString()
    {
        return pathName;
    }

    // Cambia el pathName del objeto al mismo pathName + "/" + name (parámetro)
    // Devuelve el nuevo pathName en forma de String
    public Path to(String name)
    {
        String pathRes = new String();

        if (pathName.equals("/"))
        {
            pathRes = "/" + name;
        }
        else
        {
            pathRes = pathName + "/" + name;
        }
        
        return new Path(pathRes);
    }

    // Cambia el pathName del objeto al mismo pathName un directorio atrás
    // Devuelve el nuevo pathName en forma de String
    public Path back()
    {
        if (pathName.equals("/")) return new Path("/");

        String[] tokens = pathName.split("/");
        String pathRes = new String();
        
        // Nos saltamos el primer token (vacío porque coge
        // desde el inicio hasta el primer "/", que es el primer char)
        // y nos saltamos el último para volver al dir anterior
        int i = 0;

        if(tokens[i] == "")
        {
            i = 1;
        }

        for(; i < tokens.length - 1; i++)
        {
            if(i != 0) pathRes += "/";
            pathRes += tokens[i];
        }

        return new Path(pathRes);
    }

    public Path getLastDirectory()
    {
        if (pathName.equals("") || !pathName.contains("/"))
        {
            return new Path(pathName);
        }

        String[] tokens = pathName.split("/");

        return new Path(tokens[tokens.length-1]);
    }

    public String getFirstDirectory()
    {
        String[] tokens = pathName.split("/");

        if(tokens[0] == "")
        {
            return tokens[1];
        }

        return tokens[0];
    }

    public void removeFirstDirectory()
    {
        if(!pathName.contains("/"))
        {
            setPathName("");
            return;
        }
        
        String[] tokens = pathName.split("/");

        String pathRes = "";
        
        int i = 1;

        if(tokens[0] == "")
        {
            i = 2;
        }

        while(i < tokens.length)
        {
            pathRes += tokens[i];
            if(i != tokens.length-1)
            {
                pathRes += "/";
            }

            i++;
        }

        setPathName(pathRes);
    }

    public boolean isRootPath()
    {
        return pathName.charAt(0) == '/';
    }

    public boolean hasMoreDirectories()
    {
        return pathName.contains("/");
    }

    public void removeRootBar()
    {
        if(pathName.charAt(0) == '/')
        {
            setPathName(pathName.substring(1));
        }
    }

    public boolean endsWithBar()
    {
        return (pathName.charAt(pathName.length()-1) == '/');
    }

    public boolean hasDoubleBar()
    {
        return (pathName.contains("//"));
    }
    
    /* TEST
    */
    public static void main(String[] argv)
    {
        Path prueba = new Path("/root/dir1/dir2");

        System.out.println("    ----- TEST 1: desde root -----");
        System.out.println("getPathName: " + prueba.getPathName());
        System.out.println("to(\"TARGET\"): " + prueba.to("TARGET"));
        System.out.println("back: " + prueba.back());
        System.out.println("getLastDirectory: " + prueba.getLastDirectory());
        System.out.println("getFirstDirectory: " + prueba.getFirstDirectory());
        System.out.println("isRootPath: " + prueba.isRootPath());
        // prueba.removeFirstDirectory();
        // System.out.println("removeFirstDirectory: " + prueba.getPathName());
        prueba.removeRootBar();
        System.out.println("removeRootBar: " + prueba);

        System.out.println();

        Path prueba2 = new Path("root/dir1/dir2");

        System.out.println("    ----- TEST 2: desde directorio actual -----");
        System.out.println("getPathName: " + prueba2.getPathName());
        System.out.println("to(\"TARGET\"): " + prueba2.to("TARGET"));
        System.out.println("back: " + prueba2.back());
        System.out.println("getLastDirectory: " + prueba2.getLastDirectory());
        System.out.println("getFirstDirectory: " + prueba2.getFirstDirectory());
        System.out.println("isRootPath: " + prueba2.isRootPath());
        prueba2.removeFirstDirectory();
        System.out.println("removeFirstDirectory: " + prueba2.getPathName());

    }
    
}
