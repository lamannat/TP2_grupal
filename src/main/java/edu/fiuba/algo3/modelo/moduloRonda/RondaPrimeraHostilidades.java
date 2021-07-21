package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

import java.util.List;

public class RondaPrimeraHostilidades implements Ronda {
    private final Juego juego;
//    private final List<Accion> acciones;

    public RondaPrimeraHostilidades(Juego juego) {
        this.juego = juego;

    }

    public void comenzarLaRonda(Jugador jugador){
//        for (Accion accionActual: acciones ){
//            accionActual.ejecutar(jugador);
//        }
        this.atacar(jugador);
        this.reagrupar(jugador);
        this.solicitarTarjeta(jugador);
    }

    private void atacar(Jugador jugador){
        jugador.comienzaElAtaque();
    }

    private void reagrupar(Jugador jugador){
        jugador.reagruparFuerzas();
    }

    private void solicitarTarjeta(Jugador jugador){
        jugador.solicitarTarjeta();
    }

    public Ronda siguienteRonda(){
        return new RondaHostilidadesGeneral(this.juego);
    }

}
