
import java.util.Vector;

public abstract class Deposito extends Inventario {
    Vector<Carga> cargas;
    double capacidad;

    Deposito(double _volumen)
    {
        super(_volumen);
        capacidad = _volumen;
        cargas = new Vector<Carga>();
    }

    abstract boolean guardar (Carga elem);

    public double peso()
    {
        double total = 0;
        for (Carga carga : cargas)
        {
            total += carga.peso();
        }

        return total;
    }
}

