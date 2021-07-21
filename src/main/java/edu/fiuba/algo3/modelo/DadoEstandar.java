package edu.fiuba.algo3.modelo;

import java.util.concurrent.ThreadLocalRandom;

public class DadoEstandar implements Dado {

    @Override
    public TiradaDeDados tirarDado(Integer cantidadATirar) {
        TiradaDeDados tirada = new TiradaDeDados();
        for (int i = 0; i < cantidadATirar; i++) {
            Integer resultado = ThreadLocalRandom.current().nextInt(1, 6 + 1);
            tirada.agregarResultado(resultado);
        }
        return tirada;
    }
}
