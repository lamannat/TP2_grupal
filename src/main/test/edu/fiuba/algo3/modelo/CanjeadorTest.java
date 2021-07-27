package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.simbolo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CanjeadorTest {

    @Test
    public void noSePuedeCanjearCuandoNoTenesCartas(){
        Canjeador canjeador = new Canjeador();
        assertEquals(0, canjeador.canjearCartas());
    }

    @Test
    public void noSePuedeCanjearConSoloUnaCarta(){
        Canjeador canjeador = new Canjeador();

        Carta carta1 = new Carta(new Pais("Argentina"), new SimboloNormal("globo"));;

        canjeador.agregarCartaPais(carta1);

        assertEquals(0,canjeador.canjearCartas());
    }

    @Test
    public void noSePuedeCanjearConDosCartas(){
        Canjeador canjeador = new Canjeador();

        Carta carta1 = new Carta(new Pais("Argentina"), new SimboloNormal("barco"));
        Carta carta2 = new Carta(new Pais("Mexico"), new SimboloNormal("globo"));

        System.out.println(carta1);
        System.out.println(carta2);

        canjeador.agregarCartaPais(carta1);
        canjeador.agregarCartaPais(carta2);

        assertEquals(0,canjeador.canjearCartas());
    }

    @Test
    public void noSePuedeCanjearConTresCartasSiNoSonTodasIgualesODiferentes(){
        Canjeador canjeador = new Canjeador();

        Carta carta1 = new Carta(new Pais("Argentina"), new SimboloNormal("globo"));
        Carta carta2 = new Carta(new Pais("Mexico"), new SimboloNormal("globo"));
        Carta carta3 = new Carta(new Pais("Kamchatka"), new SimboloNormal("canion"));

        canjeador.agregarCartaPais(carta1);
        canjeador.agregarCartaPais(carta2);
        canjeador.agregarCartaPais(carta3);

        assertEquals(0,canjeador.canjearCartas());
    }

    @Test
    public void noSePuedeCanjearConCuatroCartasSiNoHayTresIgualesOTresDiferentes(){
        Canjeador canjeador = new Canjeador();

        Carta carta1 = new Carta(new Pais("Argentina"), new SimboloNormal("globo"));
        Carta carta2 = new Carta(new Pais("Mexico"), new SimboloNormal("globo"));
        Carta carta3 = new Carta(new Pais("Kamchatka"), new SimboloNormal("canion"));
        Carta carta4 = new Carta(new Pais("Gobi"), new SimboloNormal("canion"));

        canjeador.agregarCartaPais(carta1);
        canjeador.agregarCartaPais(carta2);
        canjeador.agregarCartaPais(carta3);
        canjeador.agregarCartaPais(carta4);

        assertEquals(0,canjeador.canjearCartas());
    }

    @Test
    public void tresCartasMismoSimboloPrimerCanjeDevuelveCuatroFichas(){
        Canjeador canjeador = new Canjeador();
        Carta carta1 = new Carta(new Pais("Argentina"), new SimboloNormal("globo"));
        Carta carta2 = new Carta(new Pais("Mexico"), new SimboloNormal("globo"));
        Carta carta3 = new Carta(new Pais("Kamchatka"), new SimboloNormal("globo"));
        canjeador.agregarCartaPais(carta1);
        canjeador.agregarCartaPais(carta2);
        canjeador.agregarCartaPais(carta3);

        assertEquals(4, canjeador.canjearCartas());
    }

    @Test
    public void tresCartasDiferenteSimboloPrimerCanjeDevuelveCuatroFichas(){
        Canjeador canjeador = new Canjeador();
        Carta carta1 = new Carta(new Pais("Argentina"),new SimboloNormal("globo"));
        Carta carta2 = new Carta(new Pais("Mexico"),new SimboloNormal("barco"));
        Carta carta3 = new Carta(new Pais("Kamchatka"),new SimboloNormal("canion"));
        canjeador.agregarCartaPais(carta1);
        canjeador.agregarCartaPais(carta2);
        canjeador.agregarCartaPais(carta3);

        assertEquals(4, canjeador.canjearCartas());
    }

    @Test
    public void segundoCanjeDevuelveSieteFichas(){
        Canjeador canjeador = new Canjeador();
        Carta carta1 = new Carta(new Pais("Argentina"),new SimboloNormal("globo"));
        Carta carta2 = new Carta(new Pais("Mexico"),new SimboloNormal("barco"));
        Carta carta3 = new Carta(new Pais("Kamchatka"),new SimboloNormal("canion"));
        canjeador.agregarCartaPais(carta1);
        canjeador.agregarCartaPais(carta2);
        canjeador.agregarCartaPais(carta3);

        canjeador.canjearCartas();

        canjeador.agregarCartaPais(carta1);
        canjeador.agregarCartaPais(carta2);
        canjeador.agregarCartaPais(carta3);

        assertEquals(7, canjeador.canjearCartas());
    }

    @Test
    public void primerCanjeConDosCartasIgualesYUnComodin() {
        Canjeador canjeador = new Canjeador();
        Carta carta1 = new Carta(new Pais("Argentina"),new SimboloNormal("globo"));
        Carta carta2 = new Carta(new Pais("Mexico"),new Comodin("comodin"));
        Carta carta3 = new Carta(new Pais("Kamchatka"),new SimboloNormal("globo"));
        canjeador.agregarCartaPais(carta1);
        canjeador.agregarCartaPais(carta2);
        canjeador.agregarCartaPais(carta3);
        assertEquals(4, canjeador.canjearCartas());
    }

    @Test
    public void primerCanjeConDosCartasDiferentesYUnComodin() {
        Canjeador canjeador = new Canjeador();
        Carta carta1 = new Carta(new Pais("Argentina"),new SimboloNormal("globo"));
        Carta carta2 = new Carta(new Pais("Kamchatka"),new SimboloNormal("canion"));
        Carta carta3 = new Carta(new Pais("Mexico"),new Comodin("comodin"));

        canjeador.agregarCartaPais(carta1);
        canjeador.agregarCartaPais(carta2);
        canjeador.agregarCartaPais(carta3);
        assertEquals(4, canjeador.canjearCartas());
    }
}