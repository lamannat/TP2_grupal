package edu.fiuba.algo3.modelo.cartas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.simbolo.Simbolo;

public class Carta {
    private final Pais pais;
    private final Simbolo simbolo;
    private EstadoCarta estadoCarta;

    public Carta(Pais pais, Simbolo simbolo) {
        this.pais = pais;
        this.simbolo = simbolo;
        this.estadoCarta = new EstadoBocaAbajo();
    }

    public boolean sonIguales (Carta carta) { return simbolo.sonIguales(carta.simbolo); }

    public int fichasPorPais (Pais pais) {
        if (this.pais != pais || !estadoCarta.esCanjeable())
            return 0;

        estadoCarta = new EstadoBocaArriba();
        return 2;
    }

    public void devolverAlMazo (Mazo mazo) {
        this.estadoCarta = new EstadoBocaAbajo();
        mazo.agregarCarta(this);
    }

    @Override
    public String toString() {
        return pais.toString();
    }
}
