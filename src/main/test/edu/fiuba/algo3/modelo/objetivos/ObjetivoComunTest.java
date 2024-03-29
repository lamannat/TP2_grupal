package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Canjeador;
import edu.fiuba.algo3.modelo.Continente;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.ColorAzul;
import edu.fiuba.algo3.modelo.color.ColorVerde;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjetivoComunTest {

    @Test
    public void objetivoComunGeneraStringCorrespondienteAOcupar30Paises() {
        Jugador jugador = new Jugador("Jugador", new ColorAzul(), new Canjeador(new Mazo()));
        Continente continente = new Continente("Africa");
        Objetivo objetivo = new ObjetivoComun(jugador);
        assertEquals("OBJETIVO COMUN: \n- Ocupar 30 paises", objetivo.toString());
    }

    @Test
    public void jugadorConUnPaisNoGanaElObjetivoComun() {
        Jugador jugador = new Jugador("Pepito", new ColorVerde(), new Canjeador(new Mazo()));
        Pais pais = new Pais("Nombre");
        jugador.agregarPais(pais);

        ObjetivoComun objetivo = new ObjetivoComun(jugador);

        assertFalse(objetivo.cumplido());
    }

    @Test
    public void jugadorConUnPaisCumpleElObjetivoComun() {
        Jugador jugador = new Jugador("Pepito", new ColorVerde(), new Canjeador(new Mazo()));
        Pais pais = new Pais("Nombre");
        jugador.agregarPais(pais);

        ObjetivoComun objetivo = new ObjetivoComun(jugador);

        for (int i = 0; i<30 ; i++){
            jugador.agregarPais(new Pais("pais"));
        }
        assertTrue(objetivo.cumplido());
    }

}