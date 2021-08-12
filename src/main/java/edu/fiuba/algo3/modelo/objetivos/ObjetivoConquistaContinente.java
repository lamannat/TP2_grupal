package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Continente;
import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoConquistaContinente implements Objetivo{
    private final Continente continente;
    private final Jugador jugador;

    public ObjetivoConquistaContinente(Continente continente, Jugador jugador) {
        this.continente = continente;
        this.jugador = jugador;
    }

    @Override
    public boolean cumplido() {
        return this.continente.conquistadoPorJugador(this.jugador);
    }

    @Override
    public String toString() {
        return "Ocupar " + continente.getNombre();
    }
}
