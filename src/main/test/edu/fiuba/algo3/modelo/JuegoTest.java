package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.*;
import edu.fiuba.algo3.modelo.moduloRonda.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class JuegoTest {

    Canjeador canjeador = new Canjeador(new Mazo());

    private List<Continente> listaDeContientes() {
        List<Continente> continentes = new ArrayList<>();
        for (List<String> continenteYPaises : LeerArchivo.leerArchivo("paisesEnContinentes.txt")) {

            Continente continente = new Continente(continenteYPaises.get(0));
            continentes.add(continente);

            for (int i = 1; i < continenteYPaises.size(); i++)
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

        assertEquals(Valentin.contarTotalFichas(), 25);
        assertEquals(Juan.contarTotalFichas(), 25);
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
}