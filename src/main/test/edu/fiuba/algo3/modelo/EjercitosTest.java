package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class EjercitosTest {
    @Test
    public void unEjercitosNoPuedeAtacarPorDefecto() {
        Ejercitos e = new Ejercitos(Colores.MAGENTA);
        assertFalse(e.puedeAtacar());
    }

    @Test
    public void siSeAgreganFichasPuedeAtacar() {
        Ejercitos e = new Ejercitos(Colores.NEGRO);
        e.agregarEjercitos(1);
        assertTrue(e.puedeAtacar());
    }

    @Test
    public void sePuedenPerderEjercitos() {
        Ejercitos e = new Ejercitos(Colores.ROJO);
        assertFalse(e.puedeAtacar());
        e.agregarEjercitos(3);
        assertTrue(e.puedeAtacar());
        e.pierdeEjercitos(3);
        assertFalse(e.puedeAtacar());
    }

    @Test
    public void ejercitoConquistaEjercito() {
        Ejercitos a = new Ejercitos(Colores.VERDE);
        Ejercitos b = new Ejercitos(Colores.AZUL);
        a.agregarEjercitos(1);

        assertTrue(a.tieneColor(Colores.VERDE));
        assertTrue(b.tieneColor(Colores.AZUL));

        b.conquistadoPor(a);

        assertTrue(a.tieneColor(Colores.VERDE));
        assertFalse(b.tieneColor(Colores.AZUL));
        assertTrue(b.tieneColor(Colores.VERDE));
    }

    @Test
    public void cantidadMaximaParaAtacarYDefender() {
        Ejercitos ejercito = new Ejercitos(Colores.MAGENTA);
        ejercito.agregarEjercitos(3);
        // Son como máximo 3
        assertEquals(ejercito.ejercitosParaAtaque(),3);
        assertEquals(ejercito.ejercitosParaDefensa(),3);
    }

    @Test
    public void cantidadIntermediaParaAtacarYDefender() {
        Ejercitos ejercito = new Ejercitos(Colores.MAGENTA);
        ejercito.agregarEjercitos(2);
        assertEquals(ejercito.ejercitosParaAtaque(),2);
        assertEquals(ejercito.ejercitosParaDefensa(),3);
    }

    @Test
    public void cantidadMinimaParaAtacarYDefender() {
        Ejercitos ejercito = new Ejercitos(Colores.MAGENTA);
        ejercito.agregarEjercitos(1);
        assertEquals(ejercito.ejercitosParaAtaque(),1);
        assertEquals(ejercito.ejercitosParaDefensa(),2);
    }


}