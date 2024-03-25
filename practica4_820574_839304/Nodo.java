/*
* Fichero: Nodo.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 25/03/2024
*/

abstract class Nodo
{
    protected String name;
    protected Path path;
    protected Nodo parent;

    Nodo(String _name, Path _path, Nodo _parent){
        name = _name;
        path = _path;
        parent = _parent;
    }

    abstract public double getSize();
    
    /*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Nodo getParent() {
        return parent;
    }

    public void setParent(Nodo parent) {
        this.parent = parent;
    }
    */
}