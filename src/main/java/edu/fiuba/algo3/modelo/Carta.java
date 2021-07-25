package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.simbolo.Simbolo;

public class Carta {
    private final Pais pais;
    private final Simbolo simbolo;
//    private final String simbolo;

    public Carta(Pais pais, Simbolo simbolo) {
        this.pais = pais;
        this.simbolo = simbolo;
    }

//    public String getSimbolo() {
//        return simbolo;
//    }

    public boolean sonIguales (Carta carta) { return simbolo.sonIguales(carta.simbolo); }

}
