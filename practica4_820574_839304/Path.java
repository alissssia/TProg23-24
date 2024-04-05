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

    public String to_String()
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

        for(int i = 1; i < tokens.length - 1; i++)
        {
            pathRes += "/" + tokens[i];
        }

        return new Path(pathRes);
    }

    public String getLastDirectory()
    {
        String[] tokens = pathName.split("/");

        
        return tokens[tokens.length - 1];
    }
    
    /* TEST

    public static void main(String[] argv)
    {
        pathName prueba = new pathName("/root/dir1/dir2");

        System.out.println(prueba.getpathName());
        System.out.println(prueba.to("TARGET"));
        System.out.println(prueba.back());
    }
    */
}
