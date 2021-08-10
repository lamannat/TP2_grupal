package edu.fiuba.algo3.archivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeerArchivo {

    static final private String carpetaArchivo = "src/main/java/edu/fiuba/algo3/archivos/";

    static public List<List<String>> leerArchivo(String archivo) {

        List<List<String>> resultado = new ArrayList<>();

        try {
            String cadena;
            FileReader f = new FileReader(carpetaArchivo + archivo);
            BufferedReader b = new BufferedReader(f);
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
