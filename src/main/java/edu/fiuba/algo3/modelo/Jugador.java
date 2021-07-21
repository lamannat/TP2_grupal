package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.Color;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private final String nombre;
    private final Color color;
    private final List<Pais> paises;

    public Jugador(String nombre, Color color) {
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
