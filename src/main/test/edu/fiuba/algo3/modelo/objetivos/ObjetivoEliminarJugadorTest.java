package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Canjeador;
import edu.fiuba.algo3.modelo.Continente;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.ColorAzul;
import edu.fiuba.algo3.modelo.color.ColorMagenta;
import edu.fiuba.algo3.modelo.color.ColorVerde;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjetivoEliminarJugadorTest {

    @Test
    public void objetivoGeneraStringAPartirDeJKugadorADestruir() {
        Jugador jugador1 = new Jugador("Jugador", new ColorAzul(), new Canjeador(new Mazo()));
        Jugador jugador2 = new Jugador("Jugador", new ColorVerde(), new Canjeador(new Mazo()));
        Continente continente = new Continente("Africa");
        Objetivo objetivo = new ObjetivoEliminarJugador(jugador1, jugador2);
        assertEquals("Destruir el ejercito Verde", objetivo.toString());
    }

    @Test
    public void jugadorNoCumpleConObjetivoEliminarJugador(){
        Jugador paraEliminar = new Jugador("Jugador piola", new ColorVerde(),  new Canjeador(new Mazo()));
        Jugador asesino = new Jugador("Malo maloso", new ColorMagenta(), new Canjeador(new Mazo()));
        ObjetivoEliminarJugador objetivoEliminarJugador = new ObjetivoEliminarJugador(asesino, paraEliminar);

        paraEliminar.agregarPais(new Pais("Pais"));

        assertFalse(objetivoEliminarJugador.cumplido());
    }

    @Test
    public void jugadorCumpleConObjetivoEliminarJugador(){
        Jugador paraEliminar = new Jugador("Jugador piola", new ColorVerde(),  new Canjeador(new Mazo()));
        Jugador asesino = new Jugador("Malo maloso", new ColorMagenta(), new Canjeador(new Mazo()));
        ObjetivoEliminarJugador objetivoEliminarJugador = new ObjetivoEliminarJugador(asesino, paraEliminar);

        paraEliminar.setAsesino(asesino);

        assertTrue(objetivoEliminarJugador.cumplido());
    }

}