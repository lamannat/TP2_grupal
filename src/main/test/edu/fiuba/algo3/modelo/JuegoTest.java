package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.*;
import edu.fiuba.algo3.modelo.moduloRonda.Turno;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class JuegoTest {

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
        Jugador Valentin = new Jugador("Valentin", new ColorNegro());
        Jugador Juan = new Jugador("Juan", new ColorMagenta());
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(Valentin);
        jugadores.add(Juan);

        Tablero tablero = new Tablero();
        for (Continente continente : listaDeContientes())
            tablero.agregarContinente(continente);
        Turno turno = new Turno(jugadores);

        Juego juego = new Juego(tablero, turno, new DadoEstandar());

        assertEquals(Valentin.contarTotalFichas(), 25);
        assertEquals(Juan.contarTotalFichas(), 25);
    }

    @Test
    public void DespuesDeLaPrimeraRondaLosDosJugadoresTienen30Fichas(){
        Jugador Valentin = new Jugador("Valentin", new ColorNegro());
        Jugador Juan = new Jugador("Juan", new ColorMagenta());
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(Valentin);
        jugadores.add(Juan);

        Tablero tablero = new Tablero();
        for (Continente continente : listaDeContientes())
            tablero.agregarContinente(continente);
        Turno turno = new Turno(jugadores);

        Juego juego = new Juego(tablero, turno, new DadoEstandar());
        juego.comenzarRonda();

        assertEquals(Valentin.contarTotalFichas(), 30);
        assertEquals(Juan.contarTotalFichas(), 30);
    }

    @Test
    public void DespuesDeLaSegundaRondaLosDosJugadoresTienen33Fichas(){
        Jugador Valentin = new Jugador("Valentin", new ColorNegro());
        Jugador Juan = new Jugador("Juan", new ColorMagenta());
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(Valentin);
        jugadores.add(Juan);

        Tablero tablero = new Tablero();
        for (Continente continente : listaDeContientes())
            tablero.agregarContinente(continente);
        Turno turno = new Turno(jugadores);

        Juego juego = new Juego(tablero, turno, new DadoEstandar());
        juego.comenzarRonda();
        juego.siguienteRonda();
        juego.comenzarRonda();

        assertEquals(Valentin.contarTotalFichas(), 33);
        assertEquals(Juan.contarTotalFichas(), 33);
    }

    private List<Continente> listaDelContienteAsia() {
        List<Continente> continentes = new ArrayList<>();

        Continente Asia = new Continente("Asia");
        Asia.agregarPais(new Pais("China"));
        continentes.add(Asia);

        return continentes;
    }

    @Test
    public void JugadorConquistoAsia(){
        Jugador Valentin = new Jugador("Valentin", new ColorNegro());
        Jugador Juan = new Jugador("Juan", new ColorMagenta());
        Jugador Tobias = new Jugador("Tobias", new ColorVerde());

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
        Juego juego = new Juego(tablero, turno, new DadoEstandar());

        Continente Asia = tablero.encontrarContinente("Asia");
        assertTrue(Asia.conquistadoPor(Valentin));
    }
}