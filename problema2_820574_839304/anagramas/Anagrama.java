/*
* Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
* Fecha: 05/03/2024
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrama implements Comparable<Anagrama> { // tiene que ser comparable o se nos hace mucho mas dificil
    private String palabraPrincipal;
    private List<String> palabras;

    public Anagrama(String palabra) {
        palabraPrincipal = palabraPrincipal(palabra);
        palabras = new ArrayList<String>();
        palabras.add(palabra);
    }

    // esta funcion crea la palabra principal del anagrama, es decir, la palabra por la que
    // sera conocido cada anagrama (cada grupo de palabras con las mismas letras)
    public static String palabraPrincipal(String palabra) {
        char[] palabraOrdenada = palabra.toCharArray();
        Arrays.sort(palabraOrdenada); // se puede ordenar gracias a que es comparable
        return new String(palabraOrdenada);
    }

    public boolean anadirPalabra(String palabra) {
        boolean anadir = true;
        for (String p : palabras) {
            if (p.equals(palabra)) { // si ya existe la palabra no la añadimos
                return false;
            }
        }

        return true;
    }

    public void add(String palabra){
        palabras.add(palabra);
    }
 
    public int compareTo(Anagrama ana){
        if(this.palabras.size() < ana.palabras.size()){
            return -1;
        } else if (this.palabras.size() > ana.palabras.size()){
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString(){
        String resultado = "";
        
        for (String p : palabras){
            resultado += p + ", ";
        }
        resultado = resultado.substring(0, resultado.length() - 2); // quitamos el ultimo ", " y añadimos un salto de linea al final
    

        return resultado;
    }

    public int getSize(){
        return palabras.size();
    }
}