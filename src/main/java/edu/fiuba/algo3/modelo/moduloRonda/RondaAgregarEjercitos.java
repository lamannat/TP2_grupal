package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

public abstract class RondaAgregarEjercitos implements Ronda{

    protected Juego juego;
    protected static int cantFichas;

    public void comenzarLaRonda(Jugador jugador) {
        this.juego.darleFichasAJugador(jugador, cantFichas);
    }

}
