/*
* Fichero: Nodo.java
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 25/03/2024
*/

abstract class Nodo
{
    protected String name;
    protected Path path;
    protected Directorio parent;

    Nodo(String _name, Directorio _parent){
        name = _name;
        path = _parent.getPath().to(name);
        parent = _parent;
    }

    Nodo(Directorio _dir){
        name = "root";
        path = new Path("/");
        parent = _dir;
    }

    abstract public int getSize();
    
    
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

    public Directorio getParent() {
        return parent;
    }

    public void setParent(Directorio parent) {
        this.parent = parent;
    }

    public boolean equals(Nodo n) {
        return this.getPath().getPathName().equals(n.getPath().getPathName());
    }
    
}