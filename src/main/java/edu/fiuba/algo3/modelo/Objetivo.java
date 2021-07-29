package edu.fiuba.algo3.modelo;

public class Objetivo {
    private final Jugador jugador;
    private int minimoDePaises;

    public Objetivo(Jugador jugador) {
        this.jugador = jugador;
    }

    public void minimoDePaises(int i) {
        minimoDePaises = i;
    }

    public boolean cumplido() {
        return jugador.ganador(minimoDePaises);
    }
}
