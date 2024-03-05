/*
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 05/03/2024
*/

import java.util.*;

public class ConjuntoAnagramas {
    Map<String, Anagrama> anagramas; // usamos un map para que sea mas facil buscar anagramas

    public ConjuntoAnagramas() {
        anagramas = new HashMap<String, Anagrama>();
    }

    public void anadirAnagrama(String palabra) {
        String palabraPrincipal = Anagrama.PalabraPrincipal(palabra); 

        if (anagramas.containsKey(palabraPrincipal)) { // si ya existe el anagrama, añadimos la palabra
            anagramas.get(palabraPrincipal).anadirPalabra(palabra);

        } else { // si no existe, creamos un nuevo anagrama
            Anagrama anagrama = new Anagrama(palabra);
            anagramas.put(palabraPrincipal, anagrama);
        }
    }

    public String toString() {
        String resultado = "";
        for (Anagrama anagrama : anagramas.values()) {
            resultado += anagrama.toString() + "\n";
        }
        return resultado;
    }
}