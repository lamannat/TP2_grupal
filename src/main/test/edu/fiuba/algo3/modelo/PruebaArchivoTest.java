package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PruebaArchivoTest {

    @Test
    public void prueba() {
        PruebaArchivo p = new PruebaArchivo();
        try {
            p.muestraContenido("paises.txt");
        } catch (FileNotFoundException e) {
            System.out.println("noooo");
        } catch (IOException f){
            System.out.println("nooo2");
        }

    }
}