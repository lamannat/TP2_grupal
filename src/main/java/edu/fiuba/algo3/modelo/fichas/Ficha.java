package edu.fiuba.algo3.modelo.fichas;

public class Ficha {
    private EstadoFicha estadoFicha;

    public Ficha() {
        resetear();
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
