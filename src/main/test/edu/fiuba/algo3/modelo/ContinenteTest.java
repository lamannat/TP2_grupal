package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContinenteTest {

    @Test
    public void continenteConquistado() {
        Continente continente = new Continente("Africa");
        Pais pais1 = new Pais("Egipto");
        Pais pais2 = new Pais("Sahara");
        Pais pais3 = new Pais("Etiopía");
        Pais pais4 = new Pais("Zaire");

        pais1.setColor(new ColorAzul());
        pais2.setColor(new ColorAzul());
        pais3.setColor(new ColorAzul());
        pais4.setColor(new ColorAzul());

        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        continente.agregarPais(pais3);
        continente.agregarPais(pais4);

        assertTrue(continente.conquistadoPor(new ColorAzul()));
    }

    @Test
    public void continenteNoConquistado() {
        Continente continente = new Continente("Africa");
        Pais pais1 = new Pais("Egipto");
        Pais pais2 = new Pais("Sahara");
        Pais pais3 = new Pais("Etiopía");
        Pais pais4 = new Pais("Zaire");

        pais1.setColor(new ColorAzul());
        pais2.setColor(new ColorMagenta());
        pais3.setColor(new ColorAzul());
        pais4.setColor(new ColorAzul());

        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        continente.agregarPais(pais3);
        continente.agregarPais(pais4);

        assertFalse(continente.conquistadoPor(new ColorAzul()));
    }

    @Test
    public void cantidadDePaisesConquistados() {
        Continente continente = new Continente("Africa");
        Pais pais1 = new Pais("Egipto");
        Pais pais2 = new Pais("Sahara");
        Pais pais3 = new Pais("Etiopía");
        Pais pais4 = new Pais("Zaire");

        pais1.setColor(new ColorAzul());
        pais2.setColor(new ColorMagenta());
        pais3.setColor(new ColorNegro());
        pais4.setColor(new ColorAzul());

        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        continente.agregarPais(pais3);
        continente.agregarPais(pais4);

        assertEquals(continente.cantidadPaisesConquistadosPor(new ColorAzul()),2);
        assertEquals(continente.cantidadPaisesConquistadosPor(new ColorMagenta()),1);
        assertEquals(continente.cantidadPaisesConquistadosPor(new ColorNegro()),1);
    }

    @Test
    public void continenteNoTienePaisesConUnColor() {
        Continente continente = new Continente("Africa");
        Pais pais1 = new Pais("Egipto");
        Pais pais2 = new Pais("Sahara");
        Pais pais3 = new Pais("Etiopía");
        Pais pais4 = new Pais("Zaire");

        pais1.setColor(new ColorAzul());
        pais2.setColor(new ColorMagenta());
        pais3.setColor(new ColorNegro());
        pais4.setColor(new ColorAzul());

        continente.agregarPais(pais1);
        continente.agregarPais(pais2);
        continente.agregarPais(pais3);
        continente.agregarPais(pais4);

        assertTrue(continente.sinPaisesDe(new ColorRojo()));
        assertTrue(continente.sinPaisesDe(new ColorVerde()));
        assertTrue(continente.sinPaisesDe(new ColorAmarillo()));
        assertFalse(continente.sinPaisesDe(new ColorAzul()));
        assertFalse(continente.sinPaisesDe(new ColorNegro()));
        assertFalse(continente.sinPaisesDe(new ColorMagenta()));
    }
}