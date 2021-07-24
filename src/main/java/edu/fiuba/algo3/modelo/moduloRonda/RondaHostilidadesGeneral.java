package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Carta;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

import java.util.List;

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
        this.solicitarCarta(jugador);
    }

    private void incorporarEjercitos(Jugador jugador){
        this.juego.jugadorReclamaPorPaises(jugador);
        this.juego.jugadorReclamaPorContinentes(jugador);
        this.juego.jugadorReclamaPorTarjetas(jugador);
    }

    private void atacar(Jugador jugador){
        jugador.comienzaElAtaque(juego.getBatalla());
    }

    private void reagrupar(Jugador jugador){
        jugador.reagruparFuerzas();
    }

    private void solicitarCarta(Jugador jugador){
        Carta carta = this.juego.cartaParaJugador(jugador);
        if (carta != null){
            jugador.solicitarCarta(carta);
        }
    }

    public Ronda siguienteRonda(){
        return new RondaHostilidadesGeneral(this.juego);
    }

}
