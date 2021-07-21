package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaisTest {

    @Test
    public void paisEmpiezaConUnaFichaYNoPuedeAtacar(){
        Pais pais = new Pais("Temeria");
        assertFalse(pais.puedeAtacar());
    }

    @Test
    public void paisEmpiezaConUnaFichaPuedeAtacarSiSeAgregaFicha(){
        Pais pais = new Pais("Temeria");
        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha(Colores.AZUL));

        pais.agregarEjercitos(fichas);
        assertTrue(pais.puedeAtacar());
    }

    // Esta prueba es trivial. La dejamos ?
    @Test
    public void inicialmenteUnPaisNoTieneLimitrofes() {
        Pais pais1 = new Pais("China");
        Pais pais2 = new Pais("Japón");
        assertFalse(pais1.tienePaisLimitrofe(pais2));
        assertFalse(pais2.tienePaisLimitrofe(pais1));
    }


    @Test
    public void agregarUnPaisLimitrofeHaceAlPaisAgregadoLimitrofe(){
        Pais pais = new Pais("Temeria");
        Pais paisLimitrofe = new Pais("Redania");
        pais.agregarPaisLimitrofe(paisLimitrofe);
        assertTrue(pais.tienePaisLimitrofe(paisLimitrofe));
    }

    @Test
    public void agregarUnPaisLimitrofeHaceAlPaisAgregadoLimitrofeReciprocamente(){
        Pais pais = new Pais("Temeria");
        Pais paisLimitrofe = new Pais("Redania");
        pais.agregarPaisLimitrofe(paisLimitrofe);
        assertTrue(paisLimitrofe.tienePaisLimitrofe(pais));
    }

    @Test
    public void sePruebaQueNoSonLimitrofes() {
        Pais pais1 = new Pais("China");
        Pais pais2 = new Pais("Japón");
        Pais pais3 = new Pais("Corea");

        pais1.agregarPaisLimitrofe(pais2);

        assertFalse(pais1.tienePaisLimitrofe(pais3));
        assertFalse(pais2.tienePaisLimitrofe(pais3));
    }

    @Test
    public void ataqueEntreDosPaisesSiDefensorPierdeTodasSusFichasDebeCambiarDeColor(){
        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria");
        paisDefensor = new Pais("Kaedwen");

        paisAtacante.setColor(Colores.VERDE);
        paisDefensor.setColor(Colores.AMARILLO);

        paisAtacante.agregarPaisLimitrofe(paisDefensor);

        List<Ficha> fichas = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            fichas.add(new Ficha(Colores.VERDE));

        paisAtacante.agregarEjercitos(fichas);

        assertThrows(AtaqueAPaisAliadoException.class, //En el primer o segundo ataque el pais va a ser conquistado, luego de eso los ataques lanzan la excepcion.
                ()->{
                    paisAtacante.paisAtacaAPais(paisDefensor);
                    paisAtacante.paisAtacaAPais(paisDefensor);
                    paisAtacante.paisAtacaAPais(paisDefensor);
                    paisAtacante.paisAtacaAPais(paisDefensor);
                    paisAtacante.paisAtacaAPais(paisDefensor);
                });
        assertTrue(paisDefensor.tieneColor(Colores.VERDE)); //cambia de color porque despues de 5 ataques seguro perdio
    }

    @Test
    public void ataqueEntreDosPaisesSiDefensorNoPierdeTodasSusFichasNoDebeCambiarDeColor() throws EjercitosInsuficientesException, NoEsLimitrofeException, AtaqueAPaisAliadoException {
        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria");
        paisDefensor = new Pais("Kaedwen");

        paisAtacante.setColor(Colores.VERDE);
        paisDefensor.setColor(Colores.AMARILLO);

        paisAtacante.agregarPaisLimitrofe(paisDefensor);
        List<Ficha> fichasAtacante = new ArrayList<>();
        fichasAtacante.add(new Ficha(Colores.VERDE));
        paisAtacante.agregarEjercitos(fichasAtacante);


        List<Ficha> fichasDefensor = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            fichasDefensor.add(new Ficha(Colores.AMARILLO));
        paisDefensor.agregarEjercitos(fichasDefensor);

        try {
            paisAtacante.paisAtacaAPais(paisDefensor);
        } catch (AtaqueInvalidoExcepcion e) {}

        assertTrue(paisDefensor.tieneColor(Colores.AMARILLO));
    }

}
