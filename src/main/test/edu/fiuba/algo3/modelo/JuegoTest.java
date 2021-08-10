package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.archivos.LeerArchivo;
import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.*;
import edu.fiuba.algo3.modelo.moduloRonda.*;
import edu.fiuba.algo3.modelo.simbolo.SimboloNormal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JuegoTest {

    Canjeador canjeador = new Canjeador(new Mazo());

    private List<Continente> listaDeContientes() {
        List<Continente> continentes = new ArrayList<>();
        for (List<String> continenteYPaises : LeerArchivo.leerArchivo("paisesEnContinentes.txt")) {

            Continente continente = new Continente(continenteYPaises.get(0));
            continentes.add(continente);

            for (int i = 2; i < continenteYPaises.size(); i++)
                continente.agregarPais(new Pais(continenteYPaises.get(i)));
        }
        return continentes;
    }

    @Test
    public void SeIniciaElJuegoYLosDosJugadoresTienen25FichasCadaUno(){
        Jugador Valentin = new Jugador("Valentin", new ColorNegro(),canjeador);
        Jugador Juan = new Jugador("Juan", new ColorMagenta(),canjeador);
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(Valentin);
        jugadores.add(Juan);

        Tablero tablero = new Tablero();
        for (Continente continente : listaDeContientes())
            tablero.agregarContinente(continente);
        Turno turno = new Turno(jugadores);
        Batalla batalla = new Batalla(new DadoEstandar());

        Juego juego = new Juego(tablero, turno, batalla,new Mazo());

        assertEquals(25, Valentin.contarTotalFichas());
        assertEquals(25, Juan.contarTotalFichas());
    }

//    @Test
//    public void DespuesDeLaPrimeraRondaLosDosJugadoresTienen30Fichas(){
//        Jugador Valentin = new Jugador("Valentin", new ColorNegro(),canjeador);
//        Jugador Juan = new Jugador("Juan", new ColorMagenta(),canjeador);
//        List<Jugador> jugadores = new ArrayList<>();
//        jugadores.add(Valentin);
//        jugadores.add(Juan);
//
//        Tablero tablero = new Tablero();
//        for (Continente continente : listaDeContientes())
//            tablero.agregarContinente(continente);
//        Turno turno = new Turno(jugadores);
//
//        Batalla batalla = new Batalla(new DadoEstandar());
//
//        Juego juego = new Juego(tablero, turno, batalla,new Mazo());
//        Ronda primeraRonda = new RondaAgregarCincoFichas(juego);
//        juego.seleccionarRonda(primeraRonda);
//        juego.comenzarRonda();
//
//        assertEquals(30, Valentin.contarTotalFichas());
//        assertEquals(30, Juan.contarTotalFichas());
//    }
//
//    @Test
//    public void DespuesDeLaSegundaRondaLosDosJugadoresTienen33Fichas(){
//        Jugador Valentin = new Jugador("Valentin", new ColorNegro(),canjeador);
//        Jugador Juan = new Jugador("Juan", new ColorMagenta(),canjeador);
//        List<Jugador> jugadores = new ArrayList<>();
//        jugadores.add(Valentin);
//        jugadores.add(Juan);
//
//        Tablero tablero = new Tablero();
//        for (Continente continente : listaDeContientes())
//            tablero.agregarContinente(continente);
//        Turno turno = new Turno(jugadores);
//        Batalla batalla = new Batalla(new DadoEstandar());
//
//        Juego juego = new Juego(tablero, turno, batalla,new Mazo());
//        Ronda primeraRonda = new RondaAgregarCincoFichas(juego);
//        juego.seleccionarRonda(primeraRonda);
//        juego.comenzarRonda();
//        juego.siguienteRonda();
//        juego.comenzarRonda();
//
//        assertEquals(33, Valentin.contarTotalFichas());
//        assertEquals(33, Juan.contarTotalFichas());
//    }

    private List<Continente> listaDelContienteAsia() {
        List<Continente> continentes = new ArrayList<>();

        Continente Asia = new Continente("Asia");
        Asia.agregarPais(new Pais("China"));
        continentes.add(Asia);

        return continentes;
    }

    @Test
    public void JugadorConquistoAsia(){
        Jugador Valentin = new Jugador("Valentin", new ColorNegro(),canjeador);
        Jugador Juan = new Jugador("Juan", new ColorMagenta(),canjeador);
        Jugador Tobias = new Jugador("Tobias", new ColorVerde(),canjeador);

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(Valentin);
        jugadores.add(Juan);
        jugadores.add(Tobias);

        Tablero tablero = new Tablero();
        for (Continente continente : listaDelContienteAsia()) {
            if (continente.tieneNombre("Asia"))
                while (true) {
                    Pais paisSinAsignar = continente.obtenerPaisNoAsignado();
                    if (paisSinAsignar == null)
                        break;
                    Valentin.agregarPais(paisSinAsignar);
                }
            tablero.agregarContinente(continente);
        }

        Turno turno = new Turno(jugadores);
        Batalla batalla = new Batalla(new DadoEstandar());
        Juego juego = new Juego(tablero, turno, batalla, new Mazo());

        Continente Asia = tablero.encontrarContinente("Asia");
        assertTrue(Asia.conquistadoPorJugador(Valentin));
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
        redonda.agregarAccion(new AccionDePrueba());
        redonda.setSiguienteRonda(new Ronda());

        Juego juego = new Juego(tablero, turno, batalla, mazo);
        juego.seleccionarRonda(redonda);
        juego.avanzar();
        juego.avanzar();

        assertEquals(1, redonda.cantDeReseteos);
        assertEquals(segundo, juego.jugadorActual());
    }
}