package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

public class RondaAgregarCincoEjercitos implements Ronda{
    private Juego juego;
    private static int cantFichas = 5;

    public RondaAgregarCincoEjercitos(Juego juego){
        this.juego = juego;
    }

    public void comenzarLaRonda(Jugador jugador){
        this.juego.darleFichasAJugador(jugador,cantFichas);
    }

    public Ronda siguienteRonda(){
        return new RondaAgregarTresEjercitos(this.juego);
    }

}
