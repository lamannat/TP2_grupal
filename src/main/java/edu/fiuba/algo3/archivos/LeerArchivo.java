package edu.fiuba.algo3.archivos;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeerArchivo {

    static public List<List<String>> leerArchivo(String archivo) {

        List<List<String>> resultado = new ArrayList<>();

        try {
            String cadena;
            BufferedReader b = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(archivo)));
            while((cadena = b.readLine())!=null)
                resultado.add(Arrays.asList(cadena.split(",", 0)));
            b.close();
        } catch (FileNotFoundException f) {
            System.out.println("El archivo no se encontro");
            f.printStackTrace();
        } catch (IOException i) {
            System.out.println("Algo salio mal al leer el archivo");
            i.printStackTrace();
        }

        return resultado;
    }
}
