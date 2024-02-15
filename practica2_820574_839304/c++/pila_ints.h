#include <stack>

using namespace std;

class PilaInts
{
    private:
        stack<int> pila;

    public:
        PilaInts();

        void insertar(int a);
        void extraer();
        int cima();
};
