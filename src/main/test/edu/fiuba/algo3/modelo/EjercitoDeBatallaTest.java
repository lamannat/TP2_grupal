package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.ColorNegro;
import edu.fiuba.algo3.modelo.fichas.Ficha;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EjercitoDeBatallaTest {

    @Test
    public void ejercitoDeBatallaCon3FichasDevuelveTresFichas() {
        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha(new ColorNegro()));
        fichas.add(new Ficha(new ColorNegro()));
        fichas.add(new Ficha(new ColorNegro()));
        EjercitoDeBatalla ejercitoDeBatalla = new EjercitoDeBatalla(fichas);

        int fichasRestantes = ejercitoDeBatalla.fichasRestantes().size();

        assertEquals(fichasRestantes, 3);
    }

    @Test
    public void ejercitoDeBatallaCon3FichasTieneTresFichas() {
        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha(new ColorNegro()));
        fichas.add(new Ficha(new ColorNegro()));
        fichas.add(new Ficha(new ColorNegro()));
        EjercitoDeBatalla ejercitoDeBatalla = new EjercitoDeBatalla(fichas);

        int fichasTotales = ejercitoDeBatalla.cantidadDeFichas();

        assertEquals(fichasTotales, 3);
    }

    @Test
    public void ejercitoDeBatallaCon3FichasYPierdeUnaDevuelveDosFichas() {
        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha(new ColorNegro()));
        fichas.add(new Ficha(new ColorNegro()));
        fichas.add(new Ficha(new ColorNegro()));
        EjercitoDeBatalla ejercitoDeBatalla = new EjercitoDeBatalla(fichas);

        ejercitoDeBatalla.pierdeFicha();
        int fichasRestantes = ejercitoDeBatalla.fichasRestantes().size();

        assertEquals(fichasRestantes, 2);
    }

    @Test
    public void ejercitoDeBatallaCon3FichasYPierdeYTieneDosFichas() {
        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha(new ColorNegro()));
        fichas.add(new Ficha(new ColorNegro()));
        fichas.add(new Ficha(new ColorNegro()));
        EjercitoDeBatalla ejercitoDeBatalla = new EjercitoDeBatalla(fichas);

        ejercitoDeBatalla.pierdeFicha();
        int fichasTotales = ejercitoDeBatalla.cantidadDeFichas();

        assertEquals(fichasTotales, 2);
    }

}