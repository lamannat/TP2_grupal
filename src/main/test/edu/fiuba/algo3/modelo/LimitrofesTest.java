package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LimitrofesTest {

    @Test
    public void LimitrofesIniciaVacio() {
        Pais pais = new Pais("China");
        Limitrofes lim = new Limitrofes();
        assertFalse(lim.esLimitrofe(pais));
    }

    @Test
    public void agregoUnPaisALimitrofes() {
        Pais pais = new Pais("China");
        Limitrofes lim = new Limitrofes();
        lim.agregarPaisLimitrofe(pais);
        assertTrue(lim.esLimitrofe(pais));
    }

    @Test
    public void sePruebaQueNoSonLimitrofes() {
        Pais pais1 = new Pais("China");
        Pais pais2 = new Pais("Japón");
        Pais pais3 = new Pais("Corea");

        Limitrofes lim = new Limitrofes();

        lim.agregarPaisLimitrofe(pais1);
        lim.agregarPaisLimitrofe(pais2);

        assertTrue(lim.esLimitrofe(pais1));
        assertTrue(lim.esLimitrofe(pais2));
        assertFalse(lim.esLimitrofe(pais3));
    }

}