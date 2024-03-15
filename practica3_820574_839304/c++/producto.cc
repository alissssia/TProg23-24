#include "producto.h"

Producto::Producto(string _nombre, double _volumen, double _peso) 
: ProdGenerico(_nombre, _volumen, _peso), Carga(_volumen) {}

double Producto::get_peso() const
{
    return ProdGenerico::get_peso();
}

void Producto::aumentar_nivel()
{
    ProdGenerico::aumentar_nivel();
}

string Producto::nombre() const
{
    return ProdGenerico::nombre();
}