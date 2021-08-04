package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.*;
import edu.fiuba.algo3.modelo.moduloRonda.Turno;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {

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
    public void TableroDividePaisesEntreJugadoresEquitativamente(){
        Tablero tablero = new Tablero();
        for (Continente continente : listaDeContientes())
            tablero.agregarContinente(continente);

        Jugador Valentin = new Jugador("Valentin", new ColorAmarillo(),canjeador);
        Jugador Juance = new Jugador("Juance", new ColorVerde(),canjeador);

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(Valentin);
        jugadores.add(Juance);

        Turno turno = new Turno(jugadores);

        tablero.asignarPaises(turno);

        assertEquals(25, Juance.cuantosPaisesConquistados());
        assertEquals(25, Valentin.cuantosPaisesConquistados());
    }

    @Test
    public void TableroDividePaisesEntreJugadoresNoEquitativamente(){
        Tablero tablero = new Tablero();
        for (Continente continente : listaDeContientes())
            tablero.agregarContinente(continente);

        Jugador Valentin = new Jugador("Valentin", new ColorAmarillo(),canjeador);
        Jugador Juance = new Jugador("Juance", new ColorVerde(),canjeador);
        Jugador Tobias = new Jugador("Tobias", new ColorRojo(),canjeador);

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(Valentin);
        jugadores.add(Juance);
        jugadores.add(Tobias);

        Turno turno = new Turno(jugadores);

        tablero.asignarPaises(turno);

        Integer paisesValentin = Valentin.cuantosPaisesConquistados();
        Integer paisesJuance = Juance.cuantosPaisesConquistados();
        Integer paisesTobias = Tobias.cuantosPaisesConquistados();

        assertTrue(paisesValentin == 16 || paisesValentin == 17);
        assertTrue(paisesJuance == 16 || paisesJuance == 17);
        assertTrue(paisesTobias == 16 || paisesTobias == 17);
    }

}