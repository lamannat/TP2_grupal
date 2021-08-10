package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DadoEstandarTest {

    @Test
    public void dadoEstandarDevuelveUnaTiradaNoVacia() {
        Dado unDado = new DadoEstandar();
        TiradaDeDados unaTiradaEstandar = unDado.tirarDado(3);
        assertFalse(unaTiradaEstandar.tiradaVacia());
    }

    @Test
    public void dadoEstandarDevuelveUnaTiradaVacia() {
        Dado unDado = new DadoEstandar();
        TiradaDeDados unaTiradaEstandar = unDado.tirarDado(0);
        assertTrue(unaTiradaEstandar.tiradaVacia());
    }
}