#include "producto.h"

Producto::Producto(string _nombre, double _volumen, double _peso) 
: ProdGenerico(_volumen, _nombre, _peso), Carga(_volumen) {}