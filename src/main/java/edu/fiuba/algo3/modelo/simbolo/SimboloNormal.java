package edu.fiuba.algo3.modelo.simbolo;

public class SimboloNormal extends Simbolo{

    public SimboloNormal(String simbolo) {
        nombre = simbolo;
    }

    public boolean sonIguales(Simbolo simbolo) {
        return this.nombre.equals(simbolo.nombre) || simbolo.esComodin;
    }
}
