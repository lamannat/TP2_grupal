package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

public class RondaAgregarCincoEjercitos extends RondaAgregarEjercitos{

    public RondaAgregarCincoEjercitos(Juego juego){
        this.juego = juego;
        cantFichas = 5;
    }

    public Ronda siguienteRonda(){
        return new RondaAgregarTresEjercitos(this.juego);
    }

}
