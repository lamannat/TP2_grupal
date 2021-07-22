package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.List;

public class Turno {
    List<Jugador> jugadores;
    private int indice;

    public Turno(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.indice = 0;
    }

    public Jugador jugadorActual(){
        Jugador jugadorActual = jugadores.get(indice);
        indice = (indice + 1) % jugadores.size();
        return jugadorActual;
    }
}