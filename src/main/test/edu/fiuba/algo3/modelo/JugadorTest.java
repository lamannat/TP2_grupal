package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.ColorRojo;
import edu.fiuba.algo3.modelo.color.ColorVerde;
import edu.fiuba.algo3.modelo.moduloRonda.ObjetivoDePrueba;
import edu.fiuba.algo3.modelo.objetivos.Objetivo;
import edu.fiuba.algo3.modelo.objetivos.ObjetivoComun;
import edu.fiuba.algo3.modelo.simbolo.*;
import org.junit.jupiter.api.Test;

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
}