package edu.fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LimitrofesTest {

    @Test
    public void LimitrofesIniciaVacio() {
        Pais pais = new Pais("China", Colores.ROJO);
        Limitrofes lim = new Limitrofes();
        assertFalse(lim.esLimitrofe(pais));
    }

    @Test
    public void agregoUnPaisALimitrofes() {
        Pais pais = new Pais("China", Colores.VERDE);
        Limitrofes lim = new Limitrofes();
        lim.agregarPaisLimitrofe(pais);
        assertTrue(lim.esLimitrofe(pais));
    }

    @Test
    public void sePruebaQueNoSonLimitrofes() {
        Pais pais1 = new Pais("China", Colores.ROJO);
        Pais pais2 = new Pais("Japón", Colores.AMARILLO);
        Pais pais3 = new Pais("Corea", Colores.AZUL);

        Limitrofes lim = new Limitrofes();

        lim.agregarPaisLimitrofe(pais1);
        lim.agregarPaisLimitrofe(pais2);

        assertTrue(lim.esLimitrofe(pais1));
        assertTrue(lim.esLimitrofe(pais2));
        assertFalse(lim.esLimitrofe(pais3));
    }

}