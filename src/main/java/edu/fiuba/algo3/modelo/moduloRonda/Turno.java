package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Turno {
    List<Jugador> jugadores;
    private int indice;

    public Turno(List<Jugador> jugadores) {
        this.indice = 0;
        this.jugadores = jugadores;
    }

    public Jugador jugadorActual(){
        return jugadores.get(indice);
    }

    public void avanzarJugador() { indice = (indice + 1) % jugadores.size(); }
}
