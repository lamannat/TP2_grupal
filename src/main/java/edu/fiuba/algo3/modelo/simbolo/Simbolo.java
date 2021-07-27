package edu.fiuba.algo3.modelo.simbolo;

public abstract class Simbolo {
    protected String nombre = null;
    protected boolean esComodin = false; // revisar

    public abstract boolean sonIguales (Simbolo simbolo);
    public abstract boolean sonDiferentes (Simbolo simbolo);

    @Override
    public String toString() {
        return nombre;
    }
}
