package edu.fiuba.algo3.modelo;

public class Carta {
    private final Pais pais;
    private final String simbolo;
    public Carta(Pais pais, String simbolo) {
        this.pais = pais;
        this.simbolo = simbolo;
    }

    public boolean sosIgual(Carta carta){
        return carta.simbolo == this.simbolo;
    }
}
