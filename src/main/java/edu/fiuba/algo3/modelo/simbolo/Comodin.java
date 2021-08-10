package edu.fiuba.algo3.modelo.simbolo;

public class Comodin extends Simbolo{

    public Comodin(String simbolo) {
        this.nombre = simbolo;
        this.esComodin = true;
    }

    public boolean sonIguales(Simbolo simbolo) {
        return true;
    }
}
