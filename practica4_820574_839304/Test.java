import java.util.Stack;


public class Test {
    
    public static void testPWD(Shell shell)
    {
        System.out.println("Tests para probar el comando pwd:");
        System.out.println("==================================");

        String expected;
        String result;


        // Prueba 1: probar pwd con root
        expected = "/";
        result = shell.pwd();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testPWD 1: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestPWD 1 correcto");
        }

        // Prueba 2: cambio de directorio
        shell.mkdir("dir1");
        shell.cd("dir1");
        expected = "/dir1";
        result = shell.pwd();
        if (!result.equals(expected)) {
            System.out.println("Error en testPWD 2: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestPWD 2 correcto");
        }

        // Prueba 3: cambio de directorio despues de mas de un cambio
        shell.mkdir("dir2");
        shell.cd("dir2");
        shell.mkdir("dir3");
        shell.cd("dir3");
        expected = "/dir1/dir2/dir3";
        result = shell.pwd();
        if (!result.equals(expected)) {
            System.out.println("Error en testPWD 3: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestPWD 3 correcto");
        }

        // Prueba 4: directorios con nombres con espacios
        shell.mkdir("dir 4");
        shell.cd("dir 4");
        expected = "/dir1/dir2/dir3/dir 4";
        result = shell.pwd();
        if (!result.equals(expected)) {
            System.out.println("Error en testPWD 4: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestPWD 4 correcto");
        } 
        System.out.print("\n");

    }   

    public static void testLS(Shell shell)
    {
        System.out.println("Tests para probar el comando ls:");
        System.out.println("==================================");

        String expected;
        String result;

        // Prueba 1: ls con directorio vacio
        shell.mkdir("dir1");
        shell.cd("dir1");
        expected = "";
        result = shell.ls();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testLS 1: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestLS 1 correcto");
        }

        // Prueba 2: ls con un solo directorio
        shell.mkdir("dir2");
        expected = "dir2";
        result = shell.ls();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testLS 2: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestLS 2 correcto");
        }

        // Prueba 3: ls con varios directorios
        shell.mkdir("dir3");
        shell.mkdir("dir4");
        expected = "dir4\ndir3\ndir2";
        result = shell.ls();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testLS 3: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestLS 3 correcto");
        }

        // Prueba 4: ls con directorios con nombres con espacios
        shell.mkdir("dir 5");
        expected = "dir 5\ndir4\ndir3\ndir2";
        result = shell.ls();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testLS 4: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestLS 4 correcto");
        }

        // Prueba 5: ls con directorios y ficheros
        shell.vi("fichero1", 100);
        shell.vi("fichero2", 200);
        expected = "dir 5\nfichero2\ndir4\nfichero1\ndir3\ndir2";
        result = shell.ls();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testLS 5: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestLS 5 correcto");
        }

        // Prueba 6: ls con directorios y ficheros con nombres con espacios
        shell.vi("fichero 3", 300);
        expected = "dir 5\nfichero2\ndir4\nfichero1\nfichero 3\ndir3\ndir2";
        result = shell.ls();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testLS 6: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestLS 6 correcto");
        }

        // Prueba 7: ls con enlace
        shell.ln("fichero1", "enlace1");
        expected = "dir 5\nfichero2\ndir4\nfichero1\nfichero 3\nenlace1\ndir3\ndir2";
        result = shell.ls();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testLS 7: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestLS 7 correcto");
        }

        System.out.print("\n");
    }

    public static void testDU(Shell shell) {
        System.out.println("Tests para probar el comando du:");
        System.out.println("==================================");

        String expected;
        String result;

        // Prueba 1: du con directorio vacio
        expected = "";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testDU 1: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestDU 1 correcto");
        }

        // Prueba 2: du con varios ficheros
        shell.vi("fich1.txt", 100); 
        shell.vi("fich2.txt", 200); 
        expected = "fich1.txt\t100\nfich2.txt\t200";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testDU 2: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestDU 2 correcto");
        }

        // Prueba 3: du con varios ficheros y directorios
        shell.mkdir("dir1");
        expected = "fich1.txt\t100\nfich2.txt\t200\ndir1\t0";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testDU 3: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestDU 3 correcto");
        }

        // Prueba 4: du con varios ficheros, directorios y enlaces
        shell.ln("fich1.txt", "enlace1");
        expected = "fich1.txt\t100\nenlace1\t100\nfich2.txt\t200\ndir1\t0";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testDU 4: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestDU 4 correcto");
        }

        // Prueba 5: du con un bucle de enlaces FALLO ESTREPITOSO, HAY QUE ARREGLARLO
        /*shell.mkdir("dir2");
        shell.ln("dir2", "enlace2");
        shell.cd("dir2");
        shell.ln("/enlace2", "enlace3");
        shell.cd("..");
        expected = "fich1.txt\t100\nenlace1\t100\ndir2\t0\nfich2.txt\t200\ndir1\t0\nenlace2\t0";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testDU 5: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestDU 5 correcto");
        }*/

        System.out.print("\n");
    }
    
    public static void testVI(Shell shell) {
        System.out.println("Tests para probar el comando vi:");
        System.out.println("==================================");

        String expected;
        String result;

        // Prueba 1: vi con un fichero que no existe
        shell.vi("fich1.txt", 100);
        expected = "fich1.txt\t100";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testVI 1: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestVI 1 correcto");
        }

        // Prueba 2: vi con un fichero que ya existe
        shell.vi("fich1.txt", 200);
        expected = "fich1.txt\t200";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testVI 2: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestVI 2 correcto");
        }

        // Prueba 3: vi con un nombre no valido
        shell.vi("directorio/fich2.txt", 300);
        if (shell.ls().contains("fich2.txt")) 
        {
            System.out.println("Error en testVI 3: el fichero no deberia existir");
        }
        else
        {
            System.out.println("TestVI 3 correcto");
        }

        // Prueba 4: vi con un nombre con espacios
        shell.vi("fich 3.txt", 400);
        expected = "fich1.txt\t200\nfich 3.txt\t400";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testVI 4: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestVI 4 correcto");
        }

        // Prueba 5: vi con un nodo que es un directorio FALLA, HAY QUE ARREGLARLO
        shell.mkdir("dir1");
        shell.vi("dir1", 500);
        expected = "fich1.txt\t200\ndir1\t0\nfich 3.txt\t400";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testVI 5: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestVI 5 correcto");
        }

        // Prueba 6: vi con un enlace FALLA, HAY QUE ARREGLARLO
        shell.ln("dir1", "enlace1");
        shell.vi("enlace1", 600);
        expected = "fich1.txt\t200\nenlace1\t0\ndir1\t0\nfich 3.txt\t400";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testVI 6: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestVI 6 correcto");
        }
        

        

        System.out.print("\n");
    }

    public static void testMKDIR(Shell shell) {
        System.out.println("Tests para probar el comando mkdir:");
        System.out.println("==================================");

        String expected;
        String result;

        // Prueba 1: mkdir con un directorio que no existe
        shell.mkdir("dir1");
        expected = "dir1\t0";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testMKDIR 1: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestMKDIR 1 correcto");
        }

        // Prueba 2: mkdir con un directorio que ya existe
        shell.mkdir("dir1");
        expected = "dir1\t0";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testMKDIR 2: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestMKDIR 2 correcto");
        }

        // Prueba 3: mkdir con un nombre no valido
        shell.mkdir("directorio/dir2");
        if (shell.ls().contains("dir2")) 
        {
            System.out.println("Error en testMKDIR 3: el directorio no deberia existir");
        }
        else
        {
            System.out.println("TestMKDIR 3 correcto");
        }

        // Prueba 4: mkdir con un nombre con espacios
        shell.mkdir("dir 3");
        expected = "dir 3\t0\ndir1\t0";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testMKDIR 4: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestMKDIR 4 correcto");
        }

        System.out.print("\n");

    }

    public static void testCD(Shell shell) {
        System.out.println("Tests para probar el comando cd:");
        System.out.println("==================================");

        // Prueba 1: cd a un directorio que existe con ruta relativa
        shell.mkdir("dir1");
        shell.cd("dir1");
        if (!shell.pwd().equals("/dir1")) 
        {
            System.out.println("Error en testCD 1: el directorio actual deberia ser /dir1");
        }
        else
        {
            System.out.println("TestCD 1 correcto");
        }

        // Prueba 2: cd a un directorio que no existe
        shell.cd("dir2");
        if (!shell.pwd().equals("/dir1")) 
        {
            System.out.println("Error en testCD 2: el directorio actual deberia ser /dir1");
        }
        else
        {
            System.out.println("TestCD 2 correcto");
        }

        // Prueba 3: cd al padre
        shell.mkdir("dir2");
        shell.cd("..");
        if (!shell.pwd().equals("/")) 
        {
            System.out.println("Error en testCD 3: el directorio actual deberia ser /");
        }
        else
        {
            System.out.println("TestCD 3 correcto");
        }

        // Prueba 4: cd con ruta absoluta desde root
        shell.cd("/dir1/dir2");
        if (!shell.pwd().equals("/dir1/dir2")) 
        {
            System.out.println("Error en testCD 4: el directorio actual deberia ser /dir1/dir2");
        }
        else
        {
            System.out.println("TestCD 4 correcto");
        }

        // Prueba 5: cd con ruta absoluta desde un directorio
        shell.cd("/dir1");
        shell.cd("/dir1/dir2");
        if (!shell.pwd().equals("/dir1/dir2")) 
        {
            System.out.println("Error en testCD 5: el directorio actual deberia ser /dir1/dir2");
        }
        else
        {
            System.out.println("TestCD 5 correcto");
        }

        // Prueba 6: cd a nodo que no es un directorio
        shell.vi("fich1.txt", 100);
        shell.cd("fich1.txt");
        if (!shell.pwd().equals("/dir1/dir2")) 
        {
            System.out.println("Error en testCD 6: el directorio actual deberia ser /dir1/dir2");
        }
        else
        {
            System.out.println("TestCD 6 correcto");
        }

        // Prueba 7: cd a si mismo
        shell.cd(".");
        if (!shell.pwd().equals("/dir1/dir2")) 
        {
            System.out.println("Error en testCD 7: el directorio actual deberia ser /dir1/dir2");
        }
        else
        {
            System.out.println("TestCD 7 correcto");
        }

        // Prueba 8: cd a path invalido porque acaba con /
        shell.cd("/dir1/dir2/");
        if (!shell.pwd().equals("/dir1/dir2")) 
        {
            System.out.println("Error en testCD 8: el directorio actual deberia ser /dir1/dir2");
        }
        else
        {
            System.out.println("TestCD 8 correcto");
        }

        // Prueba 9: cd a path invalido porque acaba con //
        shell.cd("/dir1/dir2//");
        if (!shell.pwd().equals("/dir1/dir2")) 
        {
            System.out.println("Error en testCD 9: el directorio actual deberia ser /dir1/dir2");
        }
        else
        {
            System.out.println("TestCD 9 correcto");
        }

        System.out.print("\n");

    }

    public static void testLN(Shell shell) {
        System.out.println("Tests para probar el comando ln:");
        System.out.println("==================================");

        String expected;
        String result;

        // Prueba 1: ln a un fichero que no existe
        shell.ln("fich1.txt", "enlace1");
        if (shell.ls().contains("enlace1")) 
        {
            System.out.println("Error en testLN 1: el enlace no deberia existir");
        }
        else
        {
            System.out.println("TestLN 1 correcto");
        }

        // Prueba 2: ln a un fichero que ya existe con ruta relativa
        shell.vi("fich1.txt", 100);
        shell.ln("fich1.txt", "enlace1");
        expected = "fich1.txt\t100\nenlace1\t100";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testLN 2: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestLN 2 correcto");
        }

        // Prueba 3: ln a un nombre no valido
        shell.ln("fich1.txt", "directorio/enlace2");   
        if (shell.ls().contains("enlace2")) 
        {
            System.out.println("Error en testLN 3: el enlace no deberia existir");
        }
        else
        {
            System.out.println("TestLN 3 correcto");
        }

        // Prueba 4: ln con un nombre que ya existe 
        shell.vi("fich2.txt", 200);
        shell.ln("fich1.txt", "fich2.txt");
        expected = "fich1.txt\t100\nenlace1\t100\nfich2.txt\t200";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testLN 4: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestLN 4 correcto");
        }

        // Prueba 5: ln a un fichero en ruta absoluta
        shell.mkdir("dir1");
        shell.cd("dir1");
        shell.vi("fich3.txt", 300);
        shell.cd("..");
        shell.ln("/dir1/fich3.txt", "enlace3");
        expected = "fich1.txt\t100\nenlace1\t100\nenlace3\t300\nfich2.txt\t200\ndir1\t300";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testLN 5: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestLN 5 correcto");
        }

        // Prueba 6: ln a directorio
        shell.ln("dir1", "enlace4");
        if (shell.ls().contains("enlace4")) 
        {
            System.out.println("TestLN 6 correcto");
        }
        else
        {
            System.out.println("Error en testLN 6: el enlace no deberia existir");
        }

        //prueba 7: enlace a enlace
        shell.cd("..");
        shell.cd("..");
        shell.ln("enlace1", "enlace5");
        expected = "fich1.txt\t100\nenlace1\t100\nenlace3\t300\nfich2.txt\t200\ndir1\t300\nenlace5\t100\nenlace4\t300";
        result = shell.du();
        if (!result.equals(expected)) 
        {
            System.out.println("Error en testLN 7: resultado = " + result + ", esperado = " + expected);
        }
        else
        {
            System.out.println("TestLN 7 correcto");
        }

        // Prueba 8: ln a una ruta absoluta que no existe
        shell.ln("/dir1/fich4.txt", "enlace6");
        if (shell.ls().contains("enlace6")) 
        {
            System.out.println("Error en testLN 8: el enlace no deberia existir");
        }
        else
        {
            System.out.println("TestLN 8 correcto");
        }

        // Prueba 9: ln a una ruta incorrecta porque acaba con /
        shell.ln("/dir1/", "enlace7");
        if (shell.ls().contains("enlace7")) 
        {
            System.out.println("Error en testLN 9: el enlace no deberia existir");
        }
        else
        {
            System.out.println("TestLN 9 correcto");
        }

        // Prueba 10: ln a una ruta incorrecta porque acaba con //
        shell.ln("/dir1//", "enlace8");
        if (shell.ls().contains("enlace8")) 
        {
            System.out.println("Error en testLN 10: el enlace no deberia existir");
        }
        else
        {
            System.out.println("TestLN 10 correcto");
        }

        // Prueba 11: ln a ruta incorrecta porque es un fichero
        shell.ln("fich1.txt/dir1", "enlace9");
        if (shell.ls().contains("enlace9")) 
        {
            System.out.println("Error en testLN 11: el enlace no deberia existir");
        }
        else
        {
            System.out.println("TestLN 11 correcto");
        }

        System.out.print("\n");
    }

    public static void testSTAT(Shell shell) {
        System.out.println("Tests para probar el comando ln:");
        System.out.println("==================================");

        String expected;
        int result;

        // Prueba 1: stat con un fichero que no existe
        result = shell.stat("fich1.txt");
        if (result != 0) 
        {
            System.out.println("Error en testSTAT 1: el fichero no deberia existir");
        }
        else
        {
            System.out.println("TestSTAT 1 correcto");
        }

        // Prueba 2: stat con un fichero que ya existe
        shell.vi("fich1.txt", 100);
        result = shell.stat("fich1.txt");
        if (result != 100) 
        {
            System.out.println("Error en testSTAT 2: resultado = " + result + ", esperado = 100");
        }
        else
        {
            System.out.println("TestSTAT 2 correcto");
        }

        // Prueba 3: stat con un enlace que ya existe
        shell.ln("fich1.txt", "enlace1");
        result = shell.stat("enlace1");
        if (result != 100) 
        {
            System.out.println("Error en testSTAT 3: resultado = " + result + ", esperado = 100");
        }
        else
        {
            System.out.println("TestSTAT 3 correcto");
        }

        // Prueba 4: stat con un directorio
        shell.mkdir("dir1");
        result = shell.stat("dir1");
        if (result != 0) 
        {
            System.out.println("Error en testSTAT 4: resultado = " + result + ", esperado = 0");
        }
        else
        {
            System.out.println("TestSTAT 4 correcto");
        }

        // Prueba 5: stat con un directorio lleno
        shell.cd("dir1");
        shell.vi("fich2.txt", 200);
        shell.vi("fich3.txt", 300);
        shell.cd("..");
        result = shell.stat("dir1");
        if (result != 500) 
        {
            System.out.println("Error en testSTAT 5: resultado = " + result + ", esperado = 500");
        }
        else
        {
            System.out.println("TestSTAT 5 correcto");
        }

        // Prueba 6: stat con ruta absoluta
        shell.cd("dir1");
        result = shell.stat("/dir1/fich2.txt");
        if (result != 200) 
        {
            System.out.println("Error en testSTAT 6: resultado = " + result + ", esperado = 200");
        }
        else
        {
            System.out.println("TestSTAT 6 correcto");
        }

        // Prueba 7: stat con ruta absoluta que termina con /
        result = shell.stat("/dir1/");
        if (result != 0) 
        {
            System.out.println("Error en testSTAT 7: resultado = " + result + ", esperado = 500");
        }
        else
        {
            System.out.println("TestSTAT 7 correcto");
        }

        // Prueba 8: stat con ruta absoluta que contiene con //
        result = shell.stat("//dir1");
        if (result != 0) 
        {
            System.out.println("Error en testSTAT 8: resultado = " + result + ", esperado = 500");
        }
        else
        {
            System.out.println("TestSTAT 8 correcto");
        }

        // Prueba 9: stat con un enlace incorrecto
        result = shell.stat("dir1/fich4.txt/enlace2");
        if (result != 0) 
        {
            System.out.println("Error en testSTAT 9: resultado = " + result + ", esperado = 0");
        }
        else
        {
            System.out.println("TestSTAT 9 correcto");
        }

        System.out.print("\n");
    }

    public static void testRM(Shell shell) {
        System.out.println("Tests para probar el comando rm:");
        System.out.println("==================================");

        String expected;
        String result;

        // Prueba 1: rm con un fichero que no existe
        shell.rm("fich1.txt");
        if (shell.ls().contains("fich1.txt")) 
        {
            System.out.println("Error en testRM 1: el fichero no deberia existir");
        }
        else
        {
            System.out.println("TestRM 1 correcto");
        }

        // Prueba 2: rm con un fichero que ya existe
        shell.vi("fich1.txt", 100);
        shell.rm("fich1.txt");
        if (shell.ls().contains("fich1.txt")) 
        {
            System.out.println("Error en testRM 2: el fichero no deberia existir");
        }
        else
        {
            System.out.println("TestRM 2 correcto");
        }

        // Prueba 3: rm con un enlace que ya existe
        shell.ln("fich1.txt", "enlace1");
        shell.rm("enlace1");
        if (shell.ls().contains("enlace1")) 
        {
            System.out.println("Error en testRM 3: el enlace no deberia existir");
        }
        else
        {
            System.out.println("TestRM 3 correcto");
        }

        // Prueba 4: rm con un directorio vacio
        shell.mkdir("dir1");
        shell.rm("dir1");
        if (shell.ls().contains("dir1")) 
        {
            System.out.println("Error en testRM 4: el directorio no deberia existir");
        }
        else
        {
            System.out.println("TestRM 4 correcto");
        }

        // Prueba 5: rm con un directorio lleno
        shell.cd("dir1");
        shell.vi("fich2.txt", 200);
        shell.vi("fich3.txt", 300);
        shell.cd("..");
        shell.rm("dir1");
        if (shell.ls().contains("dir1")) 
        {
            System.out.println("Error en testRM 5: el directorio no deberia existir");
        }
        else
        {
            System.out.println("TestRM 5 correcto");
        }

        // Prueba 6: rm de un directorio en el path actual y vuelta a root
        shell.mkdir("dir1");
        shell.cd("dir1");
        shell.rm("/dir1");
        if (shell.pwd().equals("/")) {
            System.out.println("TestRM 6 correcto");
        }
        else
        {
            System.out.println("Error en testRM 6: el directorio actual deberia ser /");
        }

        // Prueba 7: rm de un directorio en el path actual y vuelta al primer directorio que no se vaya a borrar
        shell.mkdir("dir2");
        shell.cd("dir2");
        shell.mkdir("dir3");
        shell.cd("dir3");
        shell.mkdir("dir4");
        shell.cd("dir4");
        shell.rm("/dir2/dir3");
        if (shell.pwd().equals("/dir2")) {
            System.out.println("TestRM 7 correcto");
        }
        else
        {
            System.out.println("Error en testRM 7: el directorio actual deberia ser /dir2");
        }

        // Prueba 8: rm pero el path termina con /
        shell.cd("..");
        shell.rm("/dir2/");
        if (!shell.ls().contains("dir2")) 
        {
            System.out.println("Error en testRM 8: el directorio deberia existir");
        }
        else
        {
            System.out.println("TestRM 8 correcto");
        }

        // Prueba 9: rm pero el path contiene //
        shell.mkdir("dir5");
        shell.rm("//dir5");
        if (!shell.ls().contains("dir5")) 
        {
            System.out.println("Error en testRM 9: el directorio deberia existir");
        }
        else
        {
            System.out.println("TestRM 9 correcto");
        }
    }

    public static void main(String[] argv)
    {
        Shell shell1 = new Shell();
        testPWD(shell1);

        Shell shell2 = new Shell();
        testLS(shell2);

        Shell shell3 = new Shell();
        testDU(shell3);

        Shell shell4 = new Shell();
        testVI(shell4);

        Shell shell5 = new Shell();
        testMKDIR(shell5);

        Shell shell6 = new Shell();
        testCD(shell6);

        Shell shell7 = new Shell();
        testLN(shell7);

        Shell shell8 = new Shell();
        testSTAT(shell8);

        Shell shell9 = new Shell();
        testRM(shell9);
    }
}
