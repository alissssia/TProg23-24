/*
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 05/03/2024
*/

import java.util.HashMap;
import java.util.Map;

public class ConjuntoAnagramas {
    Map<String, Anagrama> anagramas; // usamos un map para que sea mas facil buscar anagramas

    public ConjuntoAnagramas() {
        anagramas = new HashMap<String, Anagrama>();
    }

    public void anadirAnagrama(String palabra) {
        String palabraPrincipal = Anagrama.palabraPrincipal(palabra); 

        if (anagramas.containsKey(palabraPrincipal)) { // si ya existe el anagrama, añadimos la palabra
            if(anagramas.get(palabraPrincipal).anadirPalabra(palabra)){
                anagramas.get(palabraPrincipal).add(palabra);
            }

        } else { // si no existe, creamos un nuevo anagrama
            Anagrama anagrama = new Anagrama(palabra);
            anagramas.put(palabraPrincipal, anagrama);
        }
    }

    public String toString(int tamanoMinimo) {
        String resultado = "";
        for (Anagrama anagrama : anagramas.values()) {
            if (anagrama.getSize() >= tamanoMinimo){
                resultado += "\n" + anagrama.toString();
            }
        }
        
        return resultado;
    }
}