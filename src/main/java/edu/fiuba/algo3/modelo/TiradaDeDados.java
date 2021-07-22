package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TiradaDeDados {

    private List<Integer> resultados;


    public TiradaDeDados() {
        this.resultados = new ArrayList<>();
    }

    public void agregarResultado(Integer resultado) {
        resultados.add(resultado);
        Collections.sort(resultados, Collections.reverseOrder());
    }

    public boolean primerResultadoMayor(TiradaDeDados tirada) {
        if (this.resultados.isEmpty() || tirada.resultados.isEmpty())
            return false;
        return this.resultados.remove(0) > tirada.resultados.remove(0);
    }

    public boolean tiradaVacia() { return this.resultados.isEmpty(); }

}
