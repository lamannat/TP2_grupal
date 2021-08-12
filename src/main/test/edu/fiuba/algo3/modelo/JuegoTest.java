package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.ColorAmarillo;
import edu.fiuba.algo3.modelo.color.ColorVerde;
import edu.fiuba.algo3.modelo.moduloRonda.AccionDePrueba;
import edu.fiuba.algo3.modelo.moduloRonda.Ronda;
import edu.fiuba.algo3.modelo.moduloRonda.Turno;
import edu.fiuba.algo3.modelo.simbolo.SimboloNormal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class JuegoTest {

    @Test
    public void unJuegoSeCreaYGuardaLaBatallaAsignada() {
        Mazo mazo = new Mazo();
        List<Jugador> jugadores = new ArrayList<>();
        Jugador jugador = mock(Jugador.class);
        when(jugador.seguisJugando()).thenReturn(true);
        jugadores.add(jugador);
        Turno turno = new Turno(jugadores);
        Batalla batalla = new Batalla(new DadoEstandar());
        Tablero tablero = new Tablero();
        Juego juego = new Juego(tablero, turno, batalla, mazo);

        assertEquals(batalla,juego.getBatalla());
    }

    @Test
    public void siJugadorMereceCartaElJuegoSacaUnaCartaDelMazoParaDarsela() {
        Carta carta = new Carta(new Pais("Pais"), new SimboloNormal("Simbolo"));
        Mazo mazo = new Mazo();
        mazo.agregarCarta(carta);
        Jugador jugador = mock(Jugador.class);
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        when(jugador.seguisJugando()).thenReturn(true);

        Turno turno = new Turno(jugadores);
        Batalla batalla = new Batalla(new DadoEstandar());
        Tablero tablero = new Tablero();

        Juego juego = new Juego(tablero, turno, batalla, mazo);

        when(jugador.merecesCarta()).thenReturn(true);

        juego.cartaParaJugador(jugador);

        verify(jugador, times(1)).solicitarCarta(carta);
    }

    @Test
    public void siJugadorNoMereceCartaElJuegoNoLeDaUnaCarta() {
        Carta carta = new Carta(new Pais("Pais"), new SimboloNormal("Simbolo"));
        Mazo mazo = new Mazo();
        mazo.agregarCarta(carta);
        Jugador jugador = mock(Jugador.class);
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        when(jugador.seguisJugando()).thenReturn(true);

        Turno turno = new Turno(jugadores);
        Batalla batalla = new Batalla(new DadoEstandar());
        Tablero tablero = new Tablero();

        Juego juego = new Juego(tablero, turno, batalla, mazo);

        when(jugador.merecesCarta()).thenReturn(false);

        juego.cartaParaJugador(jugador);

        verify(jugador, times(0)).solicitarCarta(carta);
    }

    @Test
    public void seLeDaUnaRondaAlJuegoYAlAvanzarComienzaLaRonda() {
        Mazo mazo = new Mazo();
        Jugador jugador = new Jugador(":)", new ColorAmarillo(), new Canjeador(mazo));
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);

        Turno turno = new Turno(jugadores);
        Batalla batalla = new Batalla(new DadoEstandar());
        Tablero tablero = new Tablero();
        Ronda ronda = new Ronda();
        AccionDePrueba accion = new AccionDePrueba();
        ronda.agregarAccion(accion);

        Juego juego = new Juego(tablero, turno, batalla, mazo);
        juego.seleccionarRonda(ronda);
        assertEquals(ronda, juego.dameRonda());

        juego.avanzar();

        assertTrue(accion.comprobar(1, jugador));
    }

    @Test
    public void jugadorCumpleSuObjetivoEntoncesSeSeteaUnJugadorGanador() {
        Mazo mazo = new Mazo();
        Jugador jugador = mock(Jugador.class);
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        when(jugador.seguisJugando()).thenReturn(true);
        when(jugador.ganador()).thenReturn(true);

        Turno turno = new Turno(jugadores);
        Batalla batalla = new Batalla(new DadoEstandar());
        Tablero tablero = new Tablero();
        Ronda ronda = new Ronda();
        ronda.agregarAccion(new AccionDePrueba());

        Juego juego = new Juego(tablero, turno, batalla, mazo);
        juego.seleccionarRonda(ronda);
        juego.avanzar();

        assertEquals(juego.getJugadorGanador(), jugador);
    }

    @Test
    public void juegoAccedeALosPaisesDelTablero() {
        Mazo mazo = new Mazo();
        Jugador jugador = new Jugador(":)", new ColorAmarillo(), new Canjeador(mazo));
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        jugadores.add(new Jugador("H", new ColorVerde(), new Canjeador(mazo)));

        Turno turno = new Turno(jugadores);
        Batalla batalla = new Batalla(new DadoEstandar());

        Continente continente = new Continente("Africa");
        Pais unPais = new Pais("Egipto");
        continente.agregarPais(unPais);

        Tablero tablero = new Tablero();
        tablero.agregarContinente(continente);

        Juego juego = new Juego(tablero, turno, batalla, mazo);

        assertEquals(unPais, juego.getPaisPorNombre("Egipto"));
    }

    @Test
    public void jugadorConquistaUnContinenteYLeDanLasFichasCorrespondienteDeEseContiente() {
        Mazo mazo = new Mazo();
        Jugador jugador = new Jugador(":)", new ColorAmarillo(), new Canjeador(mazo));
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        jugadores.add(new Jugador("H", new ColorVerde(), new Canjeador(mazo)));

        Turno turno = new Turno(jugadores);
        Batalla batalla = new Batalla(new DadoEstandar());

        Continente continente = new Continente("Continente");
        for (int i = 0; i < 3; i++) {
            Pais pais = new Pais("Pais");
            continente.agregarPais(pais);
            jugador.agregarPais(pais);
        }
        continente.setFichasPorConquistado(4);

        Tablero tablero = new Tablero();
        tablero.agregarContinente(continente);

        Juego juego = new Juego(tablero, turno, batalla, mazo);

        assertEquals(4, juego.fichasPorContinente(jugador));
    }

    @Test
    public void jugadorConquistaUnContinenteYNoLeDanLasFichasCorrespondienteDeEseContiente() {
        Mazo mazo = new Mazo();
        Jugador jugador = new Jugador(":)", new ColorAmarillo(), new Canjeador(mazo));
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        jugadores.add(new Jugador("H", new ColorVerde(), new Canjeador(mazo)));

        Turno turno = new Turno(jugadores);
        Batalla batalla = new Batalla(new DadoEstandar());

        Continente continente = new Continente("Continente");
        for (int i = 0; i < 3; i++)
            continente.agregarPais(new Pais("Pais"));
        continente.setFichasPorConquistado(4);

        Tablero tablero = new Tablero();
        tablero.agregarContinente(continente);

        Juego juego = new Juego(tablero, turno, batalla, mazo);

        assertEquals(0, juego.fichasPorContinente(jugador));
    }

    @Test
    public void alAvanzarUnaVezSeReseteaLaRondaYSeAvanzaElJugador() {
        Mazo mazo = new Mazo();
        Jugador primero = new Jugador(":)", new ColorAmarillo(), new Canjeador(mazo));
        Jugador segundo = new Jugador("Loli fea", new ColorAmarillo(), new Canjeador(mazo));
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(primero);
        jugadores.add(segundo);

        Turno turno = new Turno(jugadores);
        Batalla batalla = new Batalla(new DadoEstandar());
        Tablero tablero = new Tablero();

        RondaDePrueba redonda = new RondaDePrueba();
        redonda.setSiguienteRonda(new Ronda());

        Juego juego = new Juego(tablero, turno, batalla, mazo);
        juego.seleccionarRonda(redonda);
        juego.avanzar();

        assertEquals(1, redonda.cantDeReseteos);
        assertEquals(segundo, juego.jugadorActual());
    }
}