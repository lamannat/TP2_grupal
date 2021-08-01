package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Mazo {
    private final List<Carta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<>();
    }

    public boolean contienteCarta(Carta unaCarta) {
        return cartas.contains(unaCarta);
    }

    public void agregarCarta(Carta unaCarta) {
        cartas.add(unaCarta);
    }

    public Carta sacarCartaAleatoria() {
        int i = (int) Math.floor(Math.random() * cartas.size());
        return cartas.remove(i);
    }

    public Carta sacarCarta(Carta unaCarta) {
        return cartas.remove(cartas.indexOf(unaCarta));
    }

}
