package edu.fiuba.algo3.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivo {

    static public List<List<String>> listaDePaises(String archivo) {

        List<List<String>> resultado = new ArrayList<>();

        try {
            String cadena;
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            while((cadena = b.readLine())!=null) {

                System.out.println(cadena);



            }
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
