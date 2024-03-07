public abstract class Contenedor extends Deposito{
    Contenedor(double _volumen)
    {
        super(_volumen);
        nombre = "Contenedor";
    }

    public String toString()
    {   
        String res = "";
        for (Carga carga : cargas)
        {
            res += carga.toString();
        }

        return res;
    }
}
