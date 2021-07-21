package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaisTest {

    @Test
    public void paisEmpiezaSinFichasYNoPuedeAtacar(){
        Pais pais = new Pais("Temeria");
        assertFalse(pais.fichasSuficientes());
    }

    @Test
    public void paisEmpiezaSinFichasPuedeAtacarSiSeLeAgregaDosFichas(){
        Pais pais = new Pais("Temeria");
        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha(new ColorAzul()));
        fichas.add(new Ficha(new ColorAzul()));

        pais.agregarFichas(fichas);
        assertTrue(pais.fichasSuficientes());
    }

    // Esta prueba es trivial. La dejamos?
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

        paisAtacante.setColor(new ColorVerde());
        paisDefensor.setColor(new ColorAmarillo());

        Dado unDado = mock(Dado.class);

        TiradaDeDados tiradaAtacante = new TiradaDeDados();
        tiradaAtacante.agregarResultado(6);
        tiradaAtacante.agregarResultado(6);
        when(unDado.tirarDado(2)).thenReturn(tiradaAtacante);

        TiradaDeDados tiradaDefensor = new TiradaDeDados();
        tiradaDefensor.agregarResultado(2);
        when(unDado.tirarDado(1)).thenReturn(tiradaDefensor);

        paisAtacante.agregarPaisLimitrofe(paisDefensor);

        List<Ficha> fichas = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            fichas.add(new Ficha(new ColorVerde()));

        paisAtacante.agregarFichas(fichas);
        paisDefensor.agregarFicha(new Ficha(new ColorAmarillo()));

        try {
            paisAtacante.paisAtacaAPais(paisDefensor,unDado);
        } catch (AtaqueInvalidoExcepcion | FichasInsuficientesException | NoEsLimitrofeException | AtaqueAPaisAliadoException ataqueInvalidoExcepcion) {
            ataqueInvalidoExcepcion.printStackTrace();
        }

//        assertThrows(AtaqueAPaisAliadoException.class, //En el primer o segundo ataque el pais va a ser conquistado, luego de eso los ataques lanzan la excepcion.
//                ()->{
//                    paisAtacante.paisAtacaAPais(paisDefensor);
//                    paisAtacante.paisAtacaAPais(paisDefensor);
//                    paisAtacante.paisAtacaAPais(paisDefensor);
//                    paisAtacante.paisAtacaAPais(paisDefensor);
//                    paisAtacante.paisAtacaAPais(paisDefensor);
//                });
           assertTrue(paisDefensor.tieneColor(new ColorVerde())); //cambia de color porque despues de 5 ataques seguro perdio
    }

    @Test
    public void ataqueEntreDosPaisesSiDefensorNoPierdeTodasSusFichasNoDebeCambiarDeColor() throws FichasInsuficientesException, NoEsLimitrofeException, AtaqueAPaisAliadoException {
        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria");
        paisDefensor = new Pais("Kaedwen");

        paisAtacante.setColor(new ColorVerde());
        paisDefensor.setColor(new ColorAmarillo());

        Dado unDado = mock(Dado.class);

        TiradaDeDados tiradaAtacante = new TiradaDeDados();
        tiradaAtacante.agregarResultado(1);
        when(unDado.tirarDado(1)).thenReturn(tiradaAtacante);

        TiradaDeDados tiradaDefensor = new TiradaDeDados();
        tiradaDefensor.agregarResultado(3);
        tiradaDefensor.agregarResultado(4);
        when(unDado.tirarDado(2)).thenReturn(tiradaDefensor);

        paisAtacante.agregarPaisLimitrofe(paisDefensor);

        for (int i = 0; i < 2; i++){
            paisAtacante.agregarFicha(new Ficha( new ColorVerde()));
            paisDefensor.agregarFicha(new Ficha( new ColorAmarillo()));
        }


        try {
            paisAtacante.paisAtacaAPais(paisDefensor,unDado);
        } catch (AtaqueInvalidoExcepcion | FichasInsuficientesException | NoEsLimitrofeException | AtaqueAPaisAliadoException ataqueInvalidoExcepcion) {
            ataqueInvalidoExcepcion.printStackTrace();
        }

        assertTrue(paisDefensor.tieneColor(new ColorAmarillo()));




//       Pais paisAtacante, paisDefensor;
//        paisAtacante = new Pais("Temeria");
//        paisDefensor = new Pais("Kaedwen");
//
//        paisAtacante.setColor(new ColorVerde());
//        paisDefensor.setColor(new ColorAmarillo());
//
//        paisAtacante.agregarPaisLimitrofe(paisDefensor);
//        List<Ficha> fichasAtacante = new ArrayList<>();
//        fichasAtacante.add(new Ficha(new ColorVerde()));
//        fichasAtacante.add(new Ficha(new ColorVerde()));
//        paisAtacante.agregarFichas(fichasAtacante);
//
//        List<Ficha> fichasDefensor = new ArrayList<>();
//        for (int i = 0; i < 20; i++)
//            fichasDefensor.add(new Ficha(new ColorAmarillo()));
//        paisDefensor.agregarFichas(fichasDefensor);
//
//        try {
//            paisAtacante.paisAtacaAPais(paisDefensor);
//        } catch (AtaqueInvalidoExcepcion e) {}
//
    }

}
