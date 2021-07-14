package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Dado {

    private int tirarDado() {
        return ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

    public List<Integer> tirarDados(int cantidad) {

        List<Integer> resultados = new ArrayList<>();

        for (int i = 0; i < cantidad; i++)
            resultados.add(tirarDado());

        Collections.sort(resultados, Collections.reverseOrder());
        return resultados;
    }

    static int tirarDadoDeClase() {
        return ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

    static List<Integer> tirarDadosDeClase(int cantidad) {

        List<Integer> resultados = new ArrayList<>();

        for (int i = 0; i < cantidad; i++)
            resultados.add(tirarDadoDeClase());

        Collections.sort(resultados, Collections.reverseOrder());
        return resultados;
    }

}
