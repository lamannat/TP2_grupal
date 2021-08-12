package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TiradaDeDados {

    private final List<Integer> resultados;


    public TiradaDeDados() {
        this.resultados = new ArrayList<>();
    }

    public void agregarResultado(Integer resultado) {
        resultados.add(resultado);
        Collections.sort(resultados, Collections.reverseOrder());
    }

    public boolean primerResultadoMayor(TiradaDeDados tirada) {
        return this.resultados.remove(0) > tirada.resultados.remove(0);
    }

    public boolean tiradaVacia() { return this.resultados.isEmpty(); }

}
