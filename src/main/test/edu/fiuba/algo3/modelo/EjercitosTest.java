package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class EjercitosTest {
//    @Test
//    public void unEjercitosNoPuedeAtacarPorDefecto() {
//        Ejercito e = new Ejercito();
//        assertFalse(e.puedeAtacar());
//    }
//
//    @Test
//    public void siSeAgreganFichasPuedeAtacar() {
//        Ejercito e = new Ejercito();
//        List<Ficha> fichas = new ArrayList<>();
//        fichas.add(new Ficha(new ColorAzul()));
//        e.agregarEjercitos(fichas);
//        assertTrue(e.puedeAtacar());
//    }
//
//    @Test
//    public void ejercitoConquistaAOtroEjercito() {
//        Ejercito ejercitoAtacante = new Ejercito();
//        Ejercito ejercitoDefensor = new Ejercito();
//
//        ejercitoAtacante.setColor(new ColorVerde());
//        ejercitoDefensor.setColor(new ColorAmarillo());
//
//        ejercitoAtacante.conquista(ejercitoDefensor);
//
//        assertTrue(ejercitoDefensor.tieneColor(new ColorVerde()));
//    }
//
//    @Test
//    public void ejercitoConquistaEjercito() {
//        Ejercito a = new Ejercito();
//        Ejercito b = new Ejercito();
//        a.setColor(new ColorVerde());
//        b.setColor(new ColorAzul());
//
//        List<Ficha> fichas = new ArrayList<>();
//        fichas.add(new Ficha(new ColorVerde()));
//        a.agregarEjercitos(fichas);
//
//        assertTrue(a.tieneColor(new ColorVerde()));
//        assertTrue(b.tieneColor(new ColorAzul()));
//
//        a.conquista(b);
//
//        assertTrue(a.tieneColor(new ColorVerde()));
//        assertFalse(b.tieneColor(new ColorAzul()));
//        assertTrue(b.tieneColor(new ColorVerde()));
//    }
//
//    @Test
//    public void cantidadMaximaParaAtacarYDefender() {
//        Ejercito ejercito = new Ejercito();
//        ejercito.setColor(new ColorVerde());
//
//        List<Ficha> fichas = new ArrayList<>();
//        fichas.add(new Ficha(new ColorVerde()));
//        fichas.add(new Ficha(new ColorVerde()));
//        fichas.add(new Ficha(new ColorVerde()));
//
//        ejercito.agregarEjercitos(fichas);
//        // Son como máximo 3
//        assertEquals(ejercito.ejercitosParaAtaque(),3);
//        assertEquals(ejercito.ejercitosParaDefensa(),3);
//    }
//
//    @Test
//    public void cantidadIntermediaParaAtacarYDefender() {
//        Ejercito ejercito = new Ejercito();
//        ejercito.setColor(new ColorVerde());
//
//        List<Ficha> fichas = new ArrayList<>();
//        fichas.add(new Ficha(new ColorVerde()));
//        fichas.add(new Ficha(new ColorVerde()));
//
//        ejercito.agregarEjercitos(fichas);
//        assertEquals(ejercito.ejercitosParaAtaque(),2);
//        assertEquals(ejercito.ejercitosParaDefensa(),3);
//    }
//
//    @Test
//    public void cantidadMinimaParaAtacarYDefender() {
//        Ejercito ejercito = new Ejercito();
//        ejercito.setColor(new ColorVerde());
//
//        List<Ficha> fichas = new ArrayList<>();
//        fichas.add(new Ficha(new ColorVerde()));
//
//        ejercito.agregarEjercitos(fichas);
//        assertEquals(ejercito.ejercitosParaAtaque(),1);
//        assertEquals(ejercito.ejercitosParaDefensa(),2);
//    }
//

}