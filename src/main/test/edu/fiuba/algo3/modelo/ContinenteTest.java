package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContinenteTest {

    @Test
    public void continenteConquistado() {
        Jugador j = new Jugador("Jugador", new ColorVerde());

        Continente continente = new Continente("Africa");
        Pais pais1 = new Pais("Egipto");
        Pais pais2 = new Pais("Sahara");
        Pais pais3 = new Pais("Etiopía");
        Pais pais4 = new Pais("Zaire");

        j.agregarPais(pais1);
        j.agregarPais(pais2);
        j.agregarPais(pais3);
        j.agregarPais(pais4);

        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        continente.agregarPais(pais3);
        continente.agregarPais(pais4);

        assertTrue(continente.conquistadoPorJugador(j));
    }

    @Test
    public void continenteNoConquistado(){
        Jugador j1 = new Jugador("Jugador 1", new ColorVerde());
        Jugador j2 = new Jugador("Jugador 2", new ColorMagenta());

        Continente continente = new Continente("Africa");
        Pais pais1 = new Pais("Egipto");
        Pais pais2 = new Pais("Sahara");
        Pais pais3 = new Pais("Etiopía");
        Pais pais4 = new Pais("Zaire");

        j1.agregarPais(pais1);
        j1.agregarPais(pais3);
        j1.agregarPais(pais4);

        j2.agregarPais(pais2);

        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        continente.agregarPais(pais3);
        continente.agregarPais(pais4);

        assertFalse(continente.conquistadoPorJugador(j1));
    }

    @Test
    public void cantidadDePaisesConquistados() {
        Jugador j1 = new Jugador("Jugador 1", new ColorVerde());
        Jugador j2 = new Jugador("Jugador 2", new ColorMagenta());
        Jugador j3 = new Jugador("Jugador 3", new ColorNegro());
        
        Continente continente = new Continente("Africa");
        Pais pais1 = new Pais("Egipto");
        Pais pais2 = new Pais("Sahara");
        Pais pais3 = new Pais("Etiopía");
        Pais pais4 = new Pais("Zaire");

        j1.agregarPais(pais1);
        j1.agregarPais(pais4);

        j2.agregarPais(pais2);

        j3.agregarPais(pais3);

        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        continente.agregarPais(pais3);
        continente.agregarPais(pais4);

        assertEquals(continente.cantidadPaisesConquistadosPorJugador(j1),2);
        assertEquals(continente.cantidadPaisesConquistadosPorJugador(j2),1);
        assertEquals(continente.cantidadPaisesConquistadosPorJugador(j3),1);
    }

}