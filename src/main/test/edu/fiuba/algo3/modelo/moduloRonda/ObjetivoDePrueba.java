package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.objetivos.Objetivo;

public class ObjetivoDePrueba implements Objetivo {

    private final boolean loCumpleo;

    public ObjetivoDePrueba(boolean loCumpleo) {
        this.loCumpleo = loCumpleo;
    }

    @Override
    public boolean cumplido() {
        return loCumpleo;
    }
}
