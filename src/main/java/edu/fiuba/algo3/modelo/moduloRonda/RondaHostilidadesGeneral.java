package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

public class RondaHostilidadesGeneral implements Ronda{
    private final Juego juego;
    public RondaHostilidadesGeneral(Juego juego) {
        this.juego = juego;
    }

    public void comenzarLaRonda(Jugador jugador){
//        for (Accion accionActual: acciones ){
//            accionActual.ejecutar(jugador);
//        }
        this.incorporarEjercitos(jugador);
        this.atacar(jugador);
        this.reagrupar(jugador);
        this.solicitarTarjeta(jugador);
    }

    private void incorporarEjercitos(Jugador jugador){
        this.juego.jugadorReclamaPorPaises(jugador);
        this.juego.jugadorReclamaPorContinentes(jugador);
        this.juego.jugadorReclamaPorTarjetas(jugador);
    }

    private void atacar(Jugador jugador){
        jugador.comienzaElAtaque(juego.getDado());
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
