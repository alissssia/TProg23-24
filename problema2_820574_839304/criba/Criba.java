/*
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 05/03/2024
* Comentarios: compilar con javac Criba.java, ejecutar con java Criba
*/
import java.util.*;

public class Criba {
    static void cribar (int numero) {
        List<Boolean> posiblesPrimos = new ArrayList<Boolean>(); // true si es primo, false si no

        posiblesPrimos.add(false); // el 0 no es primo
        
        for (int i = 1; i <= numero; i++) {
            posiblesPrimos.add(true); // marcamos todos como posibles primos al principio
        }

        for (int i = 2; i <= numero; i++) {
            if (posiblesPrimos.get(i)) {
                for (int j = i + i; j <= numero; j += i) { // marcamos como no primos los multiplos de i
                    posiblesPrimos.set(j, false);
                }
            }
        }

        List<Integer> primos = new ArrayList<Integer>();
        for (int i = 2; i <= numero; i++) {
            if (posiblesPrimos.get(i)) { // si es primo lo añadimos a la lista de primos
                primos.add(i);
            }
        }
        System.out.println(primos.get(primos.size() - 1)); // imprimimos el primo mayor sin ser mayor o igual que el numero
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int numero = sc.nextInt();
        cribar(numero);
        sc.close();
    }
}