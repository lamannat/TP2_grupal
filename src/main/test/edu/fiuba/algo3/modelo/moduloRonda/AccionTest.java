package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Canjeador;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.ColorAmarillo;
import edu.fiuba.algo3.modelo.fichas.Ficha;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AccionTest {

    @Test
    public void enAccionAgregarFichasJugadorAgregaFichas(){
        Jugador jugador = mock(Jugador.class);
        AgregarFichas accion = new AgregarFichas(3);

        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha());
        fichas.add(new Ficha());
        fichas.add(new Ficha());

        when(jugador.generarFichas(3)).thenReturn(fichas);

        accion.ejecutar(jugador);

        verify(jugador,times(1)).darFichas(fichas);
    }

    @Test
    public void enAccionMovimientoJugadorPreparaTropas(){
        Jugador jugador = mock(Jugador.class);
        Movimiento accion = new Movimiento();

        accion.ejecutar(jugador);
        verify(jugador,times(1)).prepararTropas();
    }

    @Test
    public void enIncorporacionJugadorAgregaFichasGanadas(){
        Jugador jugador = mock(Jugador.class);
        Juego juego = mock(Juego.class);
        Incorporacion accion = new Incorporacion(juego);

        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha());
        fichas.add(new Ficha());
        fichas.add(new Ficha());

        when(jugador.cantidadFichasGanadas(juego)).thenReturn(3);
        when(jugador.generarFichas(3)).thenReturn(fichas);

        accion.ejecutar(jugador);

        verify(jugador,times(1)).darFichas(fichas);
    }

    @Test
    public void enAtacarJugadorReseteaListaDePaisesConquistados(){
        Jugador jugador = new Jugador(":D", new ColorAmarillo(), new Canjeador(new Mazo()));
        jugador.conquistate(new Pais(":)"));
        jugador.conquistate(new Pais(":("));
        jugador.merecesConseguirUnaCarta(1);

        assertTrue(jugador.merecesCarta());

        Atacar accion = new Atacar();
        accion.ejecutar(jugador);

        jugador.merecesConseguirUnaCarta(1);
        assertFalse(jugador.merecesCarta());
    }

    @Test
    public void enSolicitarCartaJugadorTieneDosPaisesYNecesitaUnPaisParaMerecerCarta(){
        Jugador jugador = new Jugador(":D", new ColorAmarillo(), new Canjeador(new Mazo()));
        jugador.conquistate(new Pais(":P"));
        jugador.conquistate(new Pais(":/"));

        SolicitarCarta accion = new SolicitarCarta(1);
        accion.ejecutar(jugador);

        assertTrue(jugador.merecesCarta());
    }

    @Test
    public void enSolicitarCartaJugadorTieneDosPaisesYNecesitaTresPaisesParaMerecerCarta(){
        Jugador jugador = new Jugador(":D", new ColorAmarillo(), new Canjeador(new Mazo()));
        jugador.conquistate(new Pais(":|"));
        jugador.conquistate(new Pais("o.O"));

        SolicitarCarta accion = new SolicitarCarta(3);
        accion.ejecutar(jugador);

        assertFalse(jugador.merecesCarta());
    }
}
