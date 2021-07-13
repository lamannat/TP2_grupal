package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContinenteTest {

    @Test
    public void continenteConquistado() {
        Continente continente = new Continente("Africa");
        Pais pais1 = new Pais("Egipto",Colores.AZUL);
        Pais pais2 = new Pais("Sahara",Colores.AZUL);
        Pais pais3 = new Pais("Etiopía", Colores.AZUL);
        Pais pais4 = new Pais("Zaire", Colores.AZUL);

        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        continente.agregarPais(pais3);
        continente.agregarPais(pais4);

        assertTrue(continente.conquistadoPor(Colores.AZUL));
    }

    @Test
    public void continenteNoConquistado() {
        Continente continente = new Continente("Africa");
        Pais pais1 = new Pais("Egipto",Colores.AZUL);
        Pais pais2 = new Pais("Sahara",Colores.MAGENTA);
        Pais pais3 = new Pais("Etiopía", Colores.AZUL);
        Pais pais4 = new Pais("Zaire", Colores.AZUL);

        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        continente.agregarPais(pais3);
        continente.agregarPais(pais4);

        assertFalse(continente.conquistadoPor(Colores.AZUL));
    }

    @Test
    public void cantidadDePaisesConquistados() {
        Continente continente = new Continente("Africa");
        Pais pais1 = new Pais("Egipto",Colores.AZUL);
        Pais pais2 = new Pais("Sahara",Colores.MAGENTA);
        Pais pais3 = new Pais("Etiopía", Colores.NEGRO);
        Pais pais4 = new Pais("Zaire", Colores.AZUL);

        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        continente.agregarPais(pais3);
        continente.agregarPais(pais4);

        assertEquals(continente.cantidadPaisesConquistadosPor(Colores.AZUL),2);
        assertEquals(continente.cantidadPaisesConquistadosPor(Colores.MAGENTA),1);
        assertEquals(continente.cantidadPaisesConquistadosPor(Colores.NEGRO),1);
    }

    @Test
    public void continenteNoTienePaisesConUnColor() {
        Continente continente = new Continente("Africa");
        Pais pais1 = new Pais("Egipto",Colores.AZUL);
        Pais pais2 = new Pais("Sahara",Colores.MAGENTA);
        Pais pais3 = new Pais("Etiopía", Colores.NEGRO);
        Pais pais4 = new Pais("Zaire", Colores.AZUL);

        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        continente.agregarPais(pais3);
        continente.agregarPais(pais4);

        assertTrue(continente.sinPaisesDe(Colores.ROJO));
        assertTrue(continente.sinPaisesDe(Colores.VERDE));
        assertTrue(continente.sinPaisesDe(Colores.AMARILLO));
        assertFalse(continente.sinPaisesDe(Colores.AZUL));
        assertFalse(continente.sinPaisesDe(Colores.NEGRO));
        assertFalse(continente.sinPaisesDe(Colores.MAGENTA));
    }
}