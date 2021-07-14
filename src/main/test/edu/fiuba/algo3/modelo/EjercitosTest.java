package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class EjercitosTest {
    @Test
    public void unEjercitosNoPuedeAtacarPorDefecto() {
        Ejercitos e = new Ejercitos();
        assertFalse(e.puedeAtacar());
    }

    @Test
    public void siSeAgreganFichasPuedeAtacar() {
        Ejercitos e = new Ejercitos();
        e.agregarEjercitos(1);
        assertTrue(e.puedeAtacar());
    }

    @Test
    public void ejercitoConquistaAOtroEjercito() {
        Ejercitos ejercitoAtacante = new Ejercitos();
        Ejercitos ejercitoDefensor = new Ejercitos();

        ejercitoAtacante.setColor(Colores.VERDE);
        ejercitoDefensor.setColor(Colores.AMARILLO);

        ejercitoAtacante.conquista(ejercitoDefensor);

        assertTrue(ejercitoDefensor.tieneColor(Colores.VERDE));
    }

    @Test
    public void ejercitoConquistaEjercito() {
        Ejercitos a = new Ejercitos();
        Ejercitos b = new Ejercitos();
        a.setColor(Colores.VERDE);
        b.setColor(Colores.AZUL);

        a.agregarEjercitos(1);

        assertTrue(a.tieneColor(Colores.VERDE));
        assertTrue(b.tieneColor(Colores.AZUL));

        a.conquista(b);

        assertTrue(a.tieneColor(Colores.VERDE));
        assertFalse(b.tieneColor(Colores.AZUL));
        assertTrue(b.tieneColor(Colores.VERDE));
    }

    @Test
    public void cantidadMaximaParaAtacarYDefender() {
        Ejercitos ejercito = new Ejercitos();
        ejercito.agregarEjercitos(3);
        // Son como máximo 3
        assertEquals(ejercito.ejercitosParaAtaque(),3);
        assertEquals(ejercito.ejercitosParaDefensa(),3);
    }

    @Test
    public void cantidadIntermediaParaAtacarYDefender() {
        Ejercitos ejercito = new Ejercitos();
        ejercito.agregarEjercitos(2);
        assertEquals(ejercito.ejercitosParaAtaque(),2);
        assertEquals(ejercito.ejercitosParaDefensa(),3);
    }

    @Test
    public void cantidadMinimaParaAtacarYDefender() {
        Ejercitos ejercito = new Ejercitos();
        ejercito.agregarEjercitos(1);
        assertEquals(ejercito.ejercitosParaAtaque(),1);
        assertEquals(ejercito.ejercitosParaDefensa(),2);
    }


}