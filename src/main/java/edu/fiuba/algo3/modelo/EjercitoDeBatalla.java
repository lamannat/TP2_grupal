package edu.fiuba.algo3.modelo;

import java.util.List;

public class EjercitoDeBatalla {
    private final List<Ficha> fichas;

    public EjercitoDeBatalla(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    public int cantidadDeFichas() {
        return fichas.size();
    }

    public void pierdeFicha()
    {
        if (!fichas.isEmpty())
            fichas.remove(0);
    }

    public List<Ficha> fichasRestantes() {
        return this.fichas;
    }
}
