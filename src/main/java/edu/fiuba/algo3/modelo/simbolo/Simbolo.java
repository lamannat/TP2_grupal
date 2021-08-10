package edu.fiuba.algo3.modelo.simbolo;

public abstract class Simbolo {
    protected String nombre = null;
    protected boolean esComodin = false; // revisar, tal vez poner un estado, pero mucho trabajo

    public abstract boolean sonIguales (Simbolo simbolo);

    @Override
    public String toString() {
        return nombre;
    }
}
