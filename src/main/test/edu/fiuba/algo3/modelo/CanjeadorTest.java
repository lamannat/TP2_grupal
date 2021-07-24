package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.ColorRojo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CanjeadorTest {

    @Test
    public void noSePuedeCanjearCuandoNoTenesCartas(){
        Canjeador canjeador = new Canjeador();
        assertEquals(0, canjeador.canjearCartas());
    }

    @Test
    public void tresCartasMismoSimboloPrimerCanjeDevuelveCuatroFichas(){
        Canjeador canjeador = new Canjeador();
        Carta carta1 = new Carta(new Pais("Argentina"),"globo");
        Carta carta2 = new Carta(new Pais("Mexico"),"globo");
        Carta carta3 = new Carta(new Pais("Kamchatka"),"globo");
        canjeador.agregarCartaPais(carta1);
        canjeador.agregarCartaPais(carta2);
        canjeador.agregarCartaPais(carta3);

        assertEquals(4, canjeador.canjearCartas());
    }

    @Test
    public void tresCartasDiferenteSimboloPrimerCanjeDevuelveCuatroFichas(){
        Canjeador canjeador = new Canjeador();
        Carta carta1 = new Carta(new Pais("Argentina"),"globo");
        Carta carta2 = new Carta(new Pais("Mexico"),"barco");
        Carta carta3 = new Carta(new Pais("Kamchatka"),"canion");
        canjeador.agregarCartaPais(carta1);
        canjeador.agregarCartaPais(carta2);
        canjeador.agregarCartaPais(carta3);

        assertEquals(4, canjeador.canjearCartas());
    }

    @Test
    public void segundoCanjeDevuelveSieteFichas(){
        Canjeador canjeador = new Canjeador();
        Carta carta1 = new Carta(new Pais("Argentina"),"globo");
        Carta carta2 = new Carta(new Pais("Mexico"),"barco");
        Carta carta3 = new Carta(new Pais("Kamchatka"),"canion");
        canjeador.agregarCartaPais(carta1);
        canjeador.agregarCartaPais(carta2);
        canjeador.agregarCartaPais(carta3);
        canjeador.canjearCartas();
        Carta carta1 = new Carta(new Pais("Argentina"),"globo");
        Carta carta2 = new Carta(new Pais("Mexico"),"barco");
        Carta carta3 = new Carta(new Pais("Kamchatka"),"canion");
        canjeador.agregarCartaPais(carta1);
        canjeador.agregarCartaPais(carta2);
        canjeador.agregarCartaPais(carta3);

        assertEquals(4, canjeador.canjearCartas());
    }
}