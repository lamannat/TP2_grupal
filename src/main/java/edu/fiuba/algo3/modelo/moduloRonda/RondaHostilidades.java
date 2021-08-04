package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Accion;

public abstract class RondaHostilidades extends Ronda {

    protected final Juego juego;
    protected int numeroAccion;

    public RondaHostilidades(Juego juego) {
        this.juego = juego;
        this.numeroAccion = 0;
    }

    @Override
    public void comenzarLaRonda(Jugador jugador) {
        acciones.get(numeroAccion).ejecutar(jugador);
        this.notifyObservers();
        numeroAccion++;
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
