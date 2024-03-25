/*
* Fichero: Path.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 25/03/2024
*/

public class Path {
    private String path;

    Path(String _path)
    {
        path = _path;
    }


    public void setPath(String path)
    {
        this.path = path;
    }

    public String getPath()
    {
        return path;
    }

    public String to_String()
    {
        return path;
    }

    // Cambia el path del objeto al mismo path + "/" + name (parámetro)
    // Devuelve el nuevo path en forma de String
    public String to(String name)
    {
        String reString = path + "/" + name;
        this.setPath(reString);

        return reString;
    }

    // Cambia el path del objeto al mismo path un directorio atrás
    // Devuelve el nuevo path en forma de String
    public String back()
    {
        String[] tokens = path.split("/");
        String resString = new String();
        
        // Nos saltamos el primer token (vacío porque coge
        // desde el inicio hasta el primer "/", que es el primer char)
        // y nos saltamos el último para volver al dir anterior

        for(int i = 1; i < tokens.length - 1; i++)
        {
            resString += "/" + tokens[i];
        }

        this.setPath(resString);

        return resString;
    }

    
    /* TEST

    public static void main(String[] argv)
    {
        Path prueba = new Path("/root/dir1/dir2");

        System.out.println(prueba.getPath());
        System.out.println(prueba.to("TARGET"));
        System.out.println(prueba.back());
    }
    */
}
