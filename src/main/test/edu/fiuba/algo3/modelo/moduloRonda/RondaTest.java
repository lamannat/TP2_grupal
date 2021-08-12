package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Canjeador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.ColorAmarillo;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Atacar;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Movimiento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RondaTest {

    @Test
    public void unaRondaSinAccionesLaRondaSiempreTermino() {
        Ronda ronda = new Ronda();

        assertTrue(ronda.terminaste());
    }

    @Test
    public void unaRondaConUnaAccionLaRondaNoTermina() {
        Ronda ronda = new Ronda();
        ronda.agregarAccion(new Atacar());

        assertFalse(ronda.terminaste());
    }

    @Test
    public void unaRondaConUnaAccionAsignadaQueNoTerminoDevuelveSuAccionActual() {
        Ronda ronda = new Ronda();
        Atacar accion = new Atacar();
        ronda.agregarAccion(accion);
        assertEquals(accion, ronda.dameFase());
    }

    @Test
    public void unaRondaReconoceCuandoLlegoAlFinalDeSusAcciones() {
        Ronda ronda = new Ronda();
        ronda.agregarAccion(new Atacar());
        ronda.agregarAccion(new Atacar());
        ronda.agregarAccion(new Atacar());

        ronda.avanzar();
        ronda.avanzar();
        ronda.avanzar();

        assertTrue(ronda.terminaste());
    }

    @Test
    public void unaRondaEjecutaSuAccionAlcomenzarLaRonda() {
        Ronda ronda = new Ronda();
        AccionDePrueba accion = new AccionDePrueba();
        ronda.agregarAccion(accion);
        Jugador jugador = new Jugador("Nombre", new ColorAmarillo(), new Canjeador(new Mazo()));

        ronda.comenzarLaRonda(jugador);

        assertTrue(accion.comprobar(1, jugador));
    }

    @Test
    public void unaRondaEjecutaSusAccionesYDespuesDeResetearseEmpiezaPorElPrincipio() {
        Ronda ronda = new Ronda();
        AccionDePrueba accion = new AccionDePrueba();
        ronda.agregarAccion(accion);
        ronda.agregarAccion(new AccionDePrueba());
        ronda.agregarAccion(new AccionDePrueba());
        Jugador jugador = new Jugador("Nombre", new ColorAmarillo(), new Canjeador(new Mazo()));

        for (int i = 0; i < 3; i++) {
            ronda.comenzarLaRonda(jugador);
            ronda.avanzar();
        }
        ronda.resetearAcciones();
        ronda.comenzarLaRonda(jugador);

        assertTrue(accion.comprobar(2, jugador));
    }

    @Test
    public void aUnaRondaSeLePuedeAsignarUnaRondaSiguiente() {
        Ronda ronda1 = new Ronda();
        Ronda ronda2 = new Ronda();
        ronda1.agregarAccion(new Atacar());
        ronda2.agregarAccion(new Movimiento());

        ronda1.setSiguienteRonda(ronda2);

        assertEquals(ronda2, ronda1.siguienteRonda());
    }
}