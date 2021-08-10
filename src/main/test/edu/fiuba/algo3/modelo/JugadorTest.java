package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.ColorRojo;
import edu.fiuba.algo3.modelo.color.ColorVerde;
import edu.fiuba.algo3.modelo.moduloRonda.ObjetivoDePrueba;
import edu.fiuba.algo3.modelo.moduloRonda.Turno;
import edu.fiuba.algo3.modelo.objetivos.Objetivo;
import edu.fiuba.algo3.modelo.simbolo.SimboloNormal;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JugadorTest {

    Canjeador canjeador = new Canjeador(new Mazo());

    @Test
    public void agregarPaisesAJugador() {
        Jugador jugador = new Jugador("Pedro", new ColorRojo(),canjeador);

        Pais pais1 = new Pais("Aral");
        Pais pais2 = new Pais("Mongolia");
        Pais pais3 = new Pais("China");

        jugador.agregarPais(pais1);
        jugador.agregarPais(pais2);
        jugador.agregarPais(pais3);

        assertEquals(jugador.getPaisesIniciales().size(),3);
    }

    @Test
    public void jugadorColocaFichaEnPaisPropio(){
        Jugador jugador = new Jugador("Pedro", new ColorRojo(),canjeador);

        Pais pais = new Pais("Aral");

        jugador.agregarPais(pais);
        jugador.colocarFichasEnPais(jugador.generarFichas(1),pais);
        assertEquals(pais.cantidadFichas(),1);
    }

    @Test
    public void jugadorAgregaCartasEnCanjeador(){
        Carta carta1 = new Carta(new Pais("Argentina"), new SimboloNormal("x"));
        Carta carta2 = new Carta(new Pais("Chile"), new SimboloNormal("o"));
        Carta carta3 = new Carta(new Pais("Peru"), new SimboloNormal("y"));

        Canjeador canjeador = mock(Canjeador.class);
        Jugador j = new Jugador("J", new ColorVerde(),canjeador);

        j.solicitarCarta(carta1);
        j.solicitarCarta(carta2);
        j.solicitarCarta(carta3);

        verify(canjeador, times(1)).agregarCartaPais(carta1);
        verify(canjeador, times(1)).agregarCartaPais(carta2);
        verify(canjeador, times(1)).agregarCartaPais(carta3);

    }

    @Test
    public void jugadorEfectuaUnCanjeDeCartasPorFichas(){

        Mazo mazo = new Mazo();

        Carta carta1 = new Carta(new Pais("Argentina"), new SimboloNormal("x"));
        Carta carta2 = new Carta(new Pais("Chile"), new SimboloNormal("o"));
        Carta carta3 = new Carta(new Pais("Peru"), new SimboloNormal("y"));

        mazo.agregarCarta(carta1);
        mazo.agregarCarta(carta2);
        mazo.agregarCarta(carta3);

        Canjeador canjeador = new Canjeador(mazo);

        Jugador jugador = new Jugador("J", new ColorVerde(),canjeador);

        jugador.solicitarCarta(mazo.sacarCartaAleatoria());
        jugador.solicitarCarta(mazo.sacarCartaAleatoria());
        jugador.solicitarCarta(mazo.sacarCartaAleatoria());

        jugador.hacerCanjePorCarta();

        assertEquals(4,jugador.contarTotalFichas());
    }

    @Test
    public void jugadorConDosObjetivosSoloCumpleUnoEntoncesGana() {
        Jugador jugador = new Jugador("o.0", new ColorVerde(), new Canjeador(new Mazo()));

        Objetivo objetivo1 = new ObjetivoDePrueba(true);
        jugador.agregarObjetivo(objetivo1);

        Objetivo objetivo2 = new ObjetivoDePrueba(false);
        jugador.agregarObjetivo(objetivo2);

        assertTrue(jugador.ganador());
    }
    @Test
    public void jugadorConDosObjetivosNoCumpleNingunoEntoncesNoGana() {
        Jugador jugador = new Jugador("o.0", new ColorVerde(), new Canjeador(new Mazo()));

        Objetivo objetivo1 = new ObjetivoDePrueba(false);
        jugador.agregarObjetivo(objetivo1);

        Objetivo objetivo2 = new ObjetivoDePrueba(false);
        jugador.agregarObjetivo(objetivo2);

        assertFalse(jugador.ganador());
    }

    @Test
    public void jugadorTieneDosPaisesConquistadosYSeNecesitaUnPaisParaMereceUnaCarta() {
        Jugador jugador = new Jugador("o.0", new ColorVerde(), new Canjeador(new Mazo()));
        jugador.agregarPaisConquistado(new Pais("Hola1"));
        jugador.agregarPaisConquistado(new Pais("Hola2"));

        jugador.merecesConseguirUnaCarta(1);

        assertTrue(jugador.merecesCarta());
    }

    @Test
    public void jugadorMueveFichasDePaisAPais() {
        Jugador jugador = new Jugador("o.0", new ColorVerde(), new Canjeador(new Mazo()));
        Pais paisOrigen = new Pais(":0");
        Pais paisDestino = new Pais("0:");

        paisOrigen.agregarFichas(jugador.generarFichas(3));

        jugador.moverTropasAPais(paisOrigen, paisDestino, 3);

        assertEquals(3, paisDestino.cantidadFichas());
    }

    @Test
    public void jugadorCon2PaisesGana3FichasPorLaCantidadDePaisesQueTiene() {
        Juego juego = mock(Juego.class);
        Canjeador canjeador = mock(Canjeador.class);

        Jugador jugador = new Jugador("o.0", new ColorVerde(), canjeador);
        jugador.agregarPais(new Pais("Ola"));
        jugador.agregarPais(new Pais("Alo"));

        when(juego.fichasPorContinente(jugador)).thenReturn(0);
        when(canjeador.canjearCartas()).thenReturn(0);

        assertEquals(3, jugador.cantidadFichasGanadas(juego));
    }

    @Test
    public void jugadorCon8PaisesGana4FichasPorLaCantidadDePaisesQueTiene() {
        Juego juego = mock(Juego.class);
        Canjeador canjeador = mock(Canjeador.class);

        Jugador jugador = new Jugador("o.0", new ColorVerde(), canjeador);
        for (int i = 0; i < 8; i++)
            jugador.agregarPais(new Pais("Ola"));

        when(juego.fichasPorContinente(jugador)).thenReturn(0);
        when(canjeador.canjearCartas()).thenReturn(0);

        assertEquals(4, jugador.cantidadFichasGanadas(juego));
    }

    @Test
    public void jugador3CartasIgualesLeDan4FichasMasDeLas3LeDanPorLaMinimaCantidadPorPaises() {
        Juego juego = mock(Juego.class);
        Canjeador canjeador = new Canjeador(new Mazo());

        Jugador jugador = new Jugador("o.0", new ColorVerde(), canjeador);
        Carta c1 = new Carta(new Pais("1"), new SimboloNormal(";lkj"));
        Carta c2 = new Carta(new Pais("1"), new SimboloNormal(";lkj"));
        Carta c3 = new Carta(new Pais("1"), new SimboloNormal(";lkj"));
        jugador.solicitarCarta(c1);
        jugador.solicitarCarta(c2);
        jugador.solicitarCarta(c3);

        when(juego.fichasPorContinente(jugador)).thenReturn(0);

        assertEquals(7, jugador.cantidadFichasGanadas(juego));
    }

    @Test
    public void jugador3CartasDiferentesLeDan4FichasMasDeLas3LeDanPorLaMinimaCantidadPorPaises() {
        Juego juego = mock(Juego.class);
        Canjeador canjeador = new Canjeador(new Mazo());

        Jugador jugador = new Jugador("o.0", new ColorVerde(), canjeador);
        Carta c1 = new Carta(new Pais("1"), new SimboloNormal(";lkj"));
        Carta c2 = new Carta(new Pais("1"), new SimboloNormal("asdf"));
        Carta c3 = new Carta(new Pais("1"), new SimboloNormal("tryjh"));
        jugador.solicitarCarta(c1);
        jugador.solicitarCarta(c2);
        jugador.solicitarCarta(c3);

        when(juego.fichasPorContinente(jugador)).thenReturn(0);

        assertEquals(7, jugador.cantidadFichasGanadas(juego));
    }

    @Test
    public void jugador2CartasIgualesYUnaDiferenteLeDan0FichasMasDeLas3LeDanPorLaMinimaCantidadPorPaises() {
        Juego juego = mock(Juego.class);
        Canjeador canjeador = new Canjeador(new Mazo());

        Jugador jugador = new Jugador("o.0", new ColorVerde(), canjeador);
        Carta c1 = new Carta(new Pais("1"), new SimboloNormal(";lkj"));
        Carta c2 = new Carta(new Pais("1"), new SimboloNormal("asdf"));
        Carta c3 = new Carta(new Pais("1"), new SimboloNormal(";lkj"));
        jugador.solicitarCarta(c1);
        jugador.solicitarCarta(c2);
        jugador.solicitarCarta(c3);

        when(juego.fichasPorContinente(jugador)).thenReturn(0);

        assertEquals(3, jugador.cantidadFichasGanadas(juego));
    }

    @Test
    public void jugadorGana6FichasPorConquistaUnContinenteMasDeLas3LeDanPorLaMinimaCantidadPorPaises() {
        Pais pais = new Pais("oh");
        Continente continente = new Continente("OH");
        continente.setFichasPorConquistado(6);
        continente.agregarPais(pais);

        Tablero tablero = new Tablero();
        tablero.agregarContinente(continente);

        Jugador jugador = new Jugador("o.0", new ColorVerde(), canjeador);
        Juego juego = new Juego(tablero, new Turno(List.of(jugador)), new Batalla(new DadoEstandar()), new Mazo());
        Canjeador canjeador = mock(Canjeador.class);

        when(canjeador.canjearCartas()).thenReturn(0);

        assertEquals(9, jugador.cantidadFichasGanadas(juego));
    }
}