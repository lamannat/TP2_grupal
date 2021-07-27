package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.ColorRojo;
import edu.fiuba.algo3.modelo.color.ColorVerde;
import edu.fiuba.algo3.modelo.simbolo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JugadorTest {

    @Test
    public void agregarPaisesAJugador() {
        Jugador jugador = new Jugador("Pedro", new ColorRojo());

        Pais pais1 = new Pais("Aral");
        Pais pais2 = new Pais("Mongolia");
        Pais pais3 = new Pais("China");

        jugador.agregarPais(pais1);
        jugador.agregarPais(pais2);
        jugador.agregarPais(pais3);

        assertEquals(jugador.cuantosPaisesConquistados(),3);
    }

    @Test
    public void jugadorColocaFichaEnPaisPropio(){
        Jugador jugador = new Jugador("Pedro", new ColorRojo());

        Pais pais = new Pais("Aral");

        jugador.agregarPais(pais);
        jugador.colocarFichasEnPais(GeneradorFichas.generar(1,jugador.getColor()),pais);
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

        Canjeador canjeador = mock(Canjeador.class);
        Jugador j = new Jugador("J", new ColorVerde(),canjeador);

        when(canjeador.canjearCartas()).thenReturn(3);
        j.hacerCanjePorCarta();

        assertEquals(j.contarTotalFichas(),3);
    }

}