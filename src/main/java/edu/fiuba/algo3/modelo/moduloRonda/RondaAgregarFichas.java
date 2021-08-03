package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

public abstract class RondaAgregarFichas extends Ronda{

    protected Juego juego;
    protected static int cantFichas;
    private boolean terminado = false;

    public void comenzarLaRonda(Jugador jugador) {
        this.acciones.get(0).ejecutar(jugador);
        terminado = true;
        this.notifyObservers();
    }

    @Override
    public boolean terminaste(){
        return terminado;
    }

}
