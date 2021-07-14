package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    private final List<Pais> paises;

    public Tablero() {

        //paises = crearPaises();
        paises = new ArrayList<>();
    }

    public void agregarPais(Pais pais){
        paises.add(pais);
    }

    /*private List<Pais> crearPaises() {

        List paises = new ArrayList();

        paises.add(new Pais("Argentina"));
        paises.add(new Pais("Chile"));
        paises.add(new Pais("Uruguay"));
        paises.add(new Pais("Brasil"));
        paises.add(new Pais("Peru"));
        paises.add(new Pais("Colombia"));

        paises.add(new Pais("Mexico"));
        paises.add(new Pais("California"));
        paises.add(new Pais("Oregon"));
        paises.add(new Pais("Nueva York"));
        paises.add(new Pais("Terranova"));
        paises.add(new Pais("Labrador"));
        paises.add(new Pais("Groenlandia"));
        paises.add(new Pais("Canada"));
        paises.add(new Pais("Yukon"));
        paises.add(new Pais("Alaska"));

        paises.add(new Pais("Islandia"));
        paises.add(new Pais("Gran Bretaña"));
        paises.add(new Pais("España"));
        paises.add(new Pais("Francia"));
        paises.add(new Pais("Italia"));
        paises.add(new Pais("Alemania"));
        paises.add(new Pais("Polonia"));
        paises.add(new Pais("Rusia"));
        paises.add(new Pais("Suecia"));

        paises.add(new Pais("Sahara"));
        paises.add(new Pais("Etiopío"));
        paises.add(new Pais("Egipto"));
        paises.add(new Pais("Zaire"));
        paises.add(new Pais("Sudafrica"));
        paises.add(new Pais("Madagascar"));

        paises.add(new Pais("Australia"));
        paises.add(new Pais("Java"));
        paises.add(new Pais("Borneo"));
        paises.add(new Pais("Sumatra"));

        paises.add(new Pais("Arabia"));
        paises.add(new Pais("Israel"));
        paises.add(new Pais("Turquia"));
        paises.add(new Pais("Iran"));
        paises.add(new Pais("Aral"));
        paises.add(new Pais("India"));
        paises.add(new Pais("Malasia"));
        paises.add(new Pais("China"));
        paises.add(new Pais("Gobi"));
        paises.add(new Pais("Mongolia"));
        paises.add(new Pais("Siberia"));
        paises.add(new Pais("Taymir"));
        paises.add(new Pais("Tartaria"));
        paises.add(new Pais("Kamchatka"));
        paises.add(new Pais("Japon"));

    }*/
}
