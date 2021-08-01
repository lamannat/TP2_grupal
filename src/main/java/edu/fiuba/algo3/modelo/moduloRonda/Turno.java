package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Turno {
    List<Jugador> jugadores;
    private int indice;

    public Turno() {
        this.indice = 0;
    }

    public Turno(List<Jugador> jugadores) { // este no tiene que estar pero por ahora para no necesitar cambiar las pruebas
        this.jugadores = jugadores;
        this.indice = 0;
    }

    public void setearJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Jugador jugadorActual(){
        Jugador jugadorActual = jugadores.get(indice);
        indice = (indice + 1) % jugadores.size();
        return jugadorActual;
    }

    public int cantJugadores() {
        return jugadores.size();
    }


}
