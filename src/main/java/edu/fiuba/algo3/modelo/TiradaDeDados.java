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

//    private int tirarDado() {
//        return ThreadLocalRandom.current().nextInt(1, 6 + 1);
//    }
//
//    public List<Integer> tirarDados(int cantidad) {
//
//        List<Integer> resultados = new ArrayList<>();
//
//        for (int i = 0; i < cantidad; i++)
//            resultados.add(tirarDado());
//
//        Collections.sort(resultados, Collections.reverseOrder());
//        return resultados;
//    }
//
//    static int tirarDadoDeClase() {
//        return ThreadLocalRandom.current().nextInt(1, 6 + 1);
//    }
//
//    static List<Integer> tirarDadosDeClase(int cantidad) {
//
//        List<Integer> resultados = new ArrayList<>();
//
//        for (int i = 0; i < cantidad; i++)
//            resultados.add(tirarDadoDeClase());
//
//        Collections.sort(resultados, Collections.reverseOrder());
//        return resultados;
//    }

}
