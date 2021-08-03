package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Carta;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Observer;

public class RondaPrimeraHostilidades extends Ronda {

    private final Juego juego;
    private int numeroAccion;

    public RondaPrimeraHostilidades(Juego juego) {
        this.juego = juego;
        acciones.add(new Atacar());
        acciones.add(new Movimiento());
        acciones.add(new SolicitarCarta());
        numeroAccion = 0;
    }

    public void comenzarLaRonda(Jugador jugador){
        acciones.get(numeroAccion).ejecutar(jugador);
        this.notifyObservers();
        numeroAccion++;
    }

    public Ronda siguienteRonda(){
        return new RondaHostilidadesGeneral(this.juego);
    }

    @Override
    public boolean terminaste() {
        return numeroAccion == acciones.size();
    }

    @Override
    public void resetearAcciones() {
        numeroAccion = 0;
    }

    @Override
    public Accion dameFase() {
        return acciones.get(numeroAccion);
    }

}
