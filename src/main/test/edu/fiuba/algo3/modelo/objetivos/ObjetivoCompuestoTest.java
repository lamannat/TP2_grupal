package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Canjeador;
import edu.fiuba.algo3.modelo.Continente;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.ColorAmarillo;
import edu.fiuba.algo3.modelo.color.ColorMagenta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ObjetivoCompuestoTest {

    @Test
    public void objetivoCompuestoGeneraStringAPartirDeSubobjetivos() {
        List<Objetivo> subObjetivos = new ArrayList<>();
        Jugador jugador = new Jugador("Jugador", new ColorMagenta(), new Canjeador(new Mazo()));
        Continente continente = new Continente("Africa");

        subObjetivos.add(new ObjetivoConquistaContinente(continente, jugador));
        subObjetivos.add(new ObjetivoEliminarJugador(jugador, new Jugador("paraEliminar", new ColorAmarillo(), new Canjeador(new Mazo()))));

        Objetivo objetivo = new ObjetivoCompuesto(subObjetivos);
        assertEquals("OBJETIVOS:\n- Ocupar Africa\n- Destruir el ejercito Amarillo\n", objetivo.toString());
    }

    @Test
    public void jugadorNoCumpleNingunoDeSusSubobjetivosEntoncesNoCumpleElObjetivo() {
        List<Objetivo> subObjetivos = new ArrayList<>();
        Jugador jugador = new Jugador("Jugador", new ColorMagenta(), new Canjeador(new Mazo()));
        subObjetivos.add(new ObjetivoConquistaContinente(new Continente("Continente"), jugador));
        subObjetivos.add(new ObjetivoEliminarJugador(jugador, new Jugador("paraEliminar", new ColorAmarillo(), new Canjeador(new Mazo()))));

        Objetivo objetivo = new ObjetivoCompuesto(subObjetivos);
        assertFalse(objetivo.cumplido());
    }

    @Test
    public void jugadorCumpleAlgunosDeSusSubobjetivosEntoncesNoCumpleElObjetivo() {
        List<Objetivo> subObjetivos = new ArrayList<>();
        Jugador jugador = new Jugador("Jugador", new ColorMagenta(), new Canjeador(new Mazo()));
        Continente continente = new Continente("UnContinente");
        for (int i = 0; i < 10; i++) {
            Pais pais = new Pais("Pais");
            continente.agregarPais(pais);
            jugador.agregarPais(pais);
        }
        subObjetivos.add(new ObjetivoConquistaContinente(continente, jugador));
        subObjetivos.add(new ObjetivoEliminarJugador(jugador, new Jugador("paraEliminar", new ColorAmarillo(), new Canjeador(new Mazo()))));

        Objetivo objetivo = new ObjetivoCompuesto(subObjetivos);
        assertFalse(objetivo.cumplido());
    }

    @Test
    public void jugadorCumpleTodosDeSusSubobjetivosEntoncesCumpleElObjetivo() {
        List<Objetivo> subObjetivos = new ArrayList<>();
        Jugador jugador = new Jugador("Jugador", new ColorMagenta(), new Canjeador(new Mazo()));
        Continente continente = new Continente("UnContinente");
        for (int i = 0; i < 10; i++) {
            Pais pais = new Pais("Pais");
            continente.agregarPais(pais);
            jugador.agregarPais(pais);
        }
        subObjetivos.add(new ObjetivoConquistaContinente(continente, jugador));
        Jugador jugadorParaEliminar = new Jugador("paraEliminar", new ColorAmarillo(), new Canjeador(new Mazo()));
        jugadorParaEliminar.setAsesino(jugador);
        subObjetivos.add(new ObjetivoEliminarJugador(jugador, jugadorParaEliminar));

        Objetivo objetivo = new ObjetivoCompuesto(subObjetivos);
        assertTrue(objetivo.cumplido());
    }
}