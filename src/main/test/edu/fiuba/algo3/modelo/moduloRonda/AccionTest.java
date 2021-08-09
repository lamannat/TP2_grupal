package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.fichas.Ficha;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.AgregarFichas;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Movimiento;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        AgregarFichas accion = new AgregarFichas(3);

        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha());
        fichas.add(new Ficha());
        fichas.add(new Ficha());

        when(jugador.cantidadFichasGanadas(juego)).thenReturn(3);
        when(jugador.generarFichas(3)).thenReturn(fichas);

        accion.ejecutar(jugador);

        verify(jugador,times(1)).darFichas(fichas);
    }
}
