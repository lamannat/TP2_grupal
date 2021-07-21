package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

public class RondaAgregarTresEjercitos implements Ronda {
    private Juego juego;
    private static int cantFichas = 3;

    public RondaAgregarTresEjercitos(Juego juego) {
        this.juego = juego;
    }

    public void comenzarLaRonda(Jugador jugador){
        this.juego.darleFichasAJugador(jugador,cantFichas);
    }

    public Ronda siguienteRonda(){
        return new RondaPrimeraHostilidades(this.juego);
    }
}
