package edu.fiuba.algo3.modelo.fichas;

import edu.fiuba.algo3.modelo.color.*;

public class Ficha {
    private Color color;
    private EstadoFicha estadoFicha;

    public Ficha(Color color) {
        this.color = color;
        estadoFicha = new EstadoFichaParaMover();
    }

    public void resetear() {
        estadoFicha = new EstadoFichaParaMover();
    }

    public boolean puedeTransferise() {
        return estadoFicha.sePuedeMover();
    }

    public void recibida() {
        estadoFicha = new EstadoFichaTransferida();
    }
}
