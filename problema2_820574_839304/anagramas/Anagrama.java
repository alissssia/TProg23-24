/*
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 05/03/2024
*/

import java.util.*;

public class Anagrama implements Comparable<Anagrama> { // tiene que ser comparable o se nos hace mucho mas dificil
    private String palabraPrincipal;
    private List<String> palabras;

    public Anagrama(String palabra) {
        palabraPrincipal = PalabraPrincipal(palabra);
        palabras = new ArrayList<String>();
        palabras.add(palabra);
    }
    // esta funcion crea la palabra principal del anagrama, es decir, la palabra por la que 
    // sera conocido cada anagrama (cada grupo de palabras con las mismas letras)
    public String PalabraPrincipal(String palabra) { 
        char[] palabraOrdenada = palabra.toCharArray();
        Arrays.sort(palabraOrdenada); // se puede ordenar gracias a que es comparable
        return new String(palabraOrdenada);
    }

    public void anadirPalabra(String palabra) {
        for (String p : palabras) {
            if (p.equals(palabra)) { // si ya existe la palabra no la añadimos
                return;
            }
        }
        palabras.add(palabra);
    }
}