package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Accion;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Incorporacion;

public class RondaIncorporacion extends Ronda {

    private boolean terminado;

    public RondaIncorporacion(Juego juego) {
        acciones.add(new Incorporacion(juego));
        terminado = false;
    }

    @Override
    public void comenzarLaRonda(Jugador jugador) {
        this.acciones.get(0).ejecutar(jugador);
        terminado = true;
        this.notifyObservers();
    }

    @Override
    public boolean terminaste() {
        return terminado;
    }

    @Override
    public void resetearAcciones() {
    }

    @Override
    public Accion dameFase() {
        return acciones.get(0);
    }
}
