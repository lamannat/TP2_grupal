package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.color.ColorMagenta;
import edu.fiuba.algo3.modelo.color.ColorNegro;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RondaPrimeraHostilidadesTest {

//    @Test
//    public void RondaDeAtaqueJugador1AtacaYConquistaUnPais(){
//        Jugador Valentin = new Jugador("Valentin", new ColorNegro());
//        Jugador Juan = new Jugador("Juan", new ColorMagenta());
//
//        List<Jugador> jugadores = new ArrayList<>();
//        jugadores.add(Valentin);
//        jugadores.add(Juan);
//
//        Dado unDado = mock(Dado.class);
//
//        TiradaDeDados tiradaAtacante = new TiradaDeDados();
//        tiradaAtacante.agregarResultado(6);
//        tiradaAtacante.agregarResultado(6);
//        when(unDado.tirarDado(2)).thenReturn(tiradaAtacante);
//
//        TiradaDeDados tiradaDefensor = new TiradaDeDados();
//        tiradaDefensor.agregarResultado(0);
//        when(unDado.tirarDado(1)).thenReturn(tiradaDefensor);
//
//
//        Tablero tablero = new Tablero();
//        Turno turno = new Turno(jugadores);
//        Juego juego = new Juego(tablero,turno, unDado);
//        RondaPrimeraHostilidades ronda = new RondaPrimeraHostilidades(juego);
//
//        Juan.colocarFichas(GeneradorFichas.generar(2,new ColorMagenta()));
//
//        assertEquals(Valentin.cantidadDePaisesConquistados(),25);
//        assertEquals(Juan.cantidadDePaisesConquistados(),25);
//
//        ronda.comenzarLaRonda(Juan);
//
//        assertEquals(Juan.cantidadDePaisesConquistados(),26);
//        assertEquals(Valentin.cantidadDePaisesConquistados(),24);
//    }

//    @Test
//    public void RondaDeAtaqueJugador1AtacaYConquistaDosPaises(){
//        Jugador Valentin = new Jugador("Valentin", new ColorNegro());
//        Jugador Juan = new Jugador("Juan", new ColorMagenta());
//
//        List<Jugador> jugadores = new ArrayList<>();
//        jugadores.add(Valentin);
//        jugadores.add(Juan);
//
//        Dado unDado = mock(Dado.class);
//
//        TiradaDeDados tiradaAtacanteTriple = new TiradaDeDados();
//        tiradaAtacanteTriple.agregarResultado(6);
//        tiradaAtacanteTriple.agregarResultado(6);
//        tiradaAtacanteTriple.agregarResultado(6);
//        when(unDado.tirarDado(3)).thenReturn(tiradaAtacanteTriple);
//
//
//        TiradaDeDados tiradaAtacanteDoble = new TiradaDeDados();
//        tiradaAtacanteDoble.agregarResultado(6);
//        tiradaAtacanteDoble.agregarResultado(6);
//        when(unDado.tirarDado(2)).thenReturn(tiradaAtacanteDoble);
//
//        TiradaDeDados tiradaDefensor = new TiradaDeDados();
//        tiradaDefensor.agregarResultado(1);
//        when(unDado.tirarDado(1)).thenReturn(tiradaDefensor);
//
//
//        Tablero tablero = new Tablero();
//        Turno turno = new Turno(jugadores);
//        Juego juego = new Juego(tablero,turno, unDado);
//        RondaPrimeraHostilidades ronda = new RondaPrimeraHostilidades(juego);
//
//        Juan.colocarFichas(GeneradorFichas.generar(3,new ColorMagenta()));
//
//        assertEquals(Valentin.cantidadDePaisesConquistados(),25);
//        assertEquals(Juan.cantidadDePaisesConquistados(),25);
//
//        ronda.comenzarLaRonda(Juan);
//
//        assertEquals(27,Juan.cantidadDePaisesConquistados());
//        assertEquals(23,Valentin.cantidadDePaisesConquistados());
//    }
}