package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Canjeador {
    private final List<Carta> cartas;

    public Canjeador() {
        this.cartas = new ArrayList<>();
    }

    public void agregarCartaPais(Carta carta) {
        cartas.add(carta);
    }

    public List<Ficha> canjearCartas() {
        return new ArrayList<>();
    }

}
