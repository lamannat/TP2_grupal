package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private final String nombre;
    private final Colores color;
    private final List<Pais> paises;

    public Jugador(String nombre, Colores color) {
        this.nombre = nombre;
        this.color = color;
        this.paises = new ArrayList<>();
    }

    public void agregarPais(Pais pais){
        this.paises.add(pais);
        pais.setColor(this.color);
    }

    public int cuantosPaisesConquistados(){
        return paises.size();
    }
}
