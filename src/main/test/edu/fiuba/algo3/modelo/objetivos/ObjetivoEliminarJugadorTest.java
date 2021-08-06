package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Canjeador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.ColorMagenta;
import edu.fiuba.algo3.modelo.color.ColorVerde;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjetivoEliminarJugadorTest {

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