package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha(new ColorAzul()));
        e.agregarEjercitos(fichas);
        assertTrue(e.puedeAtacar());
    }

    @Test
    public void ejercitoConquistaAOtroEjercito() {
        Ejercitos ejercitoAtacante = new Ejercitos();
        Ejercitos ejercitoDefensor = new Ejercitos();

        ejercitoAtacante.setColor(new ColorVerde());
        ejercitoDefensor.setColor(new ColorAmarillo());

        ejercitoAtacante.conquista(ejercitoDefensor);

        assertTrue(ejercitoDefensor.tieneColor(new ColorVerde()));
    }

    @Test
    public void ejercitoConquistaEjercito() {
        Ejercitos a = new Ejercitos();
        Ejercitos b = new Ejercitos();
        a.setColor(new ColorVerde());
        b.setColor(new ColorAzul());

        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha(new ColorVerde()));
        a.agregarEjercitos(fichas);

        assertTrue(a.tieneColor(new ColorVerde()));
        assertTrue(b.tieneColor(new ColorAzul()));

        a.conquista(b);

        assertTrue(a.tieneColor(new ColorVerde()));
        assertFalse(b.tieneColor(new ColorAzul()));
        assertTrue(b.tieneColor(new ColorVerde()));
    }

    @Test
    public void cantidadMaximaParaAtacarYDefender() {
        Ejercitos ejercito = new Ejercitos();
        ejercito.setColor(new ColorVerde());

        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha(new ColorVerde()));
        fichas.add(new Ficha(new ColorVerde()));
        fichas.add(new Ficha(new ColorVerde()));

        ejercito.agregarEjercitos(fichas);
        // Son como máximo 3
        assertEquals(ejercito.ejercitosParaAtaque(),3);
        assertEquals(ejercito.ejercitosParaDefensa(),3);
    }

    @Test
    public void cantidadIntermediaParaAtacarYDefender() {
        Ejercitos ejercito = new Ejercitos();
        ejercito.setColor(new ColorVerde());

        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha(new ColorVerde()));
        fichas.add(new Ficha(new ColorVerde()));

        ejercito.agregarEjercitos(fichas);
        assertEquals(ejercito.ejercitosParaAtaque(),2);
        assertEquals(ejercito.ejercitosParaDefensa(),3);
    }

    @Test
    public void cantidadMinimaParaAtacarYDefender() {
        Ejercitos ejercito = new Ejercitos();
        ejercito.setColor(new ColorVerde());

        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha(new ColorVerde()));

        ejercito.agregarEjercitos(fichas);
        assertEquals(ejercito.ejercitosParaAtaque(),1);
        assertEquals(ejercito.ejercitosParaDefensa(),2);
    }


}