package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.ColorVerde;
import edu.fiuba.algo3.modelo.objetivos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjetivoTest {

    @Test
    public void jugadorConUnPaisNoGanaElObjetivoComun() {
        Jugador jugador = new Jugador("Pepito", new ColorVerde(), new Canjeador(new Mazo()));
        Pais pais = new Pais("Nombre");
        jugador.agregarPais(pais);

        ObjetivoComun objetivo = new ObjetivoComun(jugador);

        assertFalse(objetivo.cumplido());
    }

    @Test
    public void jugadorConUnPaisCumpleElObjetivoComun() {
        Jugador jugador = new Jugador("Pepito", new ColorVerde(), new Canjeador(new Mazo()));
        Pais pais = new Pais("Nombre");
        jugador.agregarPais(pais);

        ObjetivoComun objetivo = new ObjetivoComun(jugador);

        for (int i = 0; i<30 ; i++){
            jugador.agregarPais(new Pais("pais"));
        }
        assertTrue(objetivo.cumplido());
    }

    @Test
    public void jugadorConquistaContinente(){
        Continente continente = new Continente("Continente");
        Jugador jugador = new Jugador(new Canjeador(new Mazo()));
        Pais pais = new Pais("Pais");

        continente.agregarPais(pais);
        jugador.agregarPais(pais);

        ObjetivoConquistaContinente objetivo = new ObjetivoConquistaContinente(continente,jugador);

        assertTrue(objetivo.cumplido());
    }

    @Test
    public void jugadorNoConquistaContinente(){
        Continente continente = new Continente("Continente");
        Jugador jugador = new Jugador(new Canjeador(new Mazo()));
        Pais pais = new Pais("Pais");

        continente.agregarPais(pais);

        ObjetivoConquistaContinente objetivo = new ObjetivoConquistaContinente(continente, jugador);

        assertFalse(objetivo.cumplido());
    }

    @Test
    public void jugadorNoCumpleConObjetivoEliminarJugador(){
        Jugador paraEliminar = new Jugador(new Canjeador(new Mazo()));
        ObjetivoEliminarJugador objetivoEliminarJugador = new ObjetivoEliminarJugador(paraEliminar);

        paraEliminar.agregarPais(new Pais("Pais"));

        assertFalse(objetivoEliminarJugador.cumplido());
    }

    @Test
    public void jugadorCumpleConObjetivoEliminarJugador(){
        Jugador paraEliminar = new Jugador(new Canjeador(new Mazo()));
        ObjetivoEliminarJugador objetivoEliminarJugador = new ObjetivoEliminarJugador(paraEliminar);

        assertTrue(objetivoEliminarJugador.cumplido());
    }

    @Test
    public void jugadorCumpleObjetivoCantidadPaisesEnContinente(){
        Continente continente = new Continente("Continente");
        Jugador jugador = new Jugador(new Canjeador(new Mazo()));
        Pais pais1 = new Pais("Pais1");
        Pais pais2 = new Pais("Pais2");

        continente.agregarPais(pais1);
        continente.agregarPais(pais2);

        jugador.agregarPais(pais1);
        jugador.agregarPais(pais2);

        Objetivo objetivo = new ObjetivoCantidadPaisesEnContinente(continente, jugador,1);

        assertTrue(objetivo.cumplido());
    }

    @Test
    public void jugadorNoCumpleObjetivoCantidadPaisesEnContinente(){
        Continente continente = new Continente("Continente");
        Jugador jugador = new Jugador(new Canjeador(new Mazo()));
        Pais pais1 = new Pais("Pais1");
        Pais pais2 = new Pais("Pais2");
        Pais pais3 = new Pais("Pais3");

        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        continente.agregarPais(pais3);

        jugador.agregarPais(pais1);
        jugador.agregarPais(pais2);

        Objetivo objetivo = new ObjetivoCantidadPaisesEnContinente(continente, jugador,3);

        assertFalse(objetivo.cumplido());
    }
}