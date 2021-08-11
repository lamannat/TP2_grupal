package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.Color;
import edu.fiuba.algo3.modelo.color.ColorAmarillo;
import edu.fiuba.algo3.modelo.color.ColorRojo;
import edu.fiuba.algo3.modelo.color.ColorVerde;
import edu.fiuba.algo3.modelo.fichas.Ficha;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaisTest {

    Canjeador canjeador = new Canjeador(new Mazo());

    @Test
    public void paisAlQueSeleAsignaUnNombreTieneEseNombre(){
        Pais pais = new Pais("Argentina");
        assertTrue(pais.tieneNombre("Argentina"));
        assertEquals("Argentina", pais.toString());
    }

    @Test
    public void paisEmpiezaSinFichasYNoPuedeAtacar(){
        Pais pais = new Pais("Argentina");
        assertFalse(pais.fichasSuficientes());
    }

    @Test
    public void paisEmpiezaSinFichasPuedeAtacarSiSeLeAgregaDosFichas(){
        Pais pais = new Pais("Temeria");
        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha());
        fichas.add(new Ficha());

        pais.agregarFichas(fichas);
        assertTrue(pais.fichasSuficientes());
    }

    @Test
    public void paisEmpiezaSinFichasNoPuedeMoverSiSeLeAgregaFichas(){
        Pais pais = new Pais("Temeria");
        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha());
        fichas.add(new Ficha());

        pais.agregarFichas(fichas);
        assertFalse(pais.fichasSuficientesParaMover());
    }

    @Test
    public void paisEmpiezaSinFichasPuedeMoverSiSeLeAgregaFichasYSePreparanLasTropas(){
        Pais pais = new Pais("Temeria");
        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha());
        fichas.add(new Ficha());

        pais.agregarFichas(fichas);
        pais.prepararTropas();
        assertTrue(pais.fichasSuficientesParaMover());
    }

    @Test
    public void paisAlQueSeLeAgreganDosFichasPuedeMoverUnaSiPreviamenteSePreparanLasTropas(){
        Pais pais = new Pais("Temeria");
        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha());
        fichas.add(new Ficha());

        pais.agregarFichas(fichas);
        pais.prepararTropas();
        assertEquals(1, pais.fichasParaMover());
    }

    @Test
    public void unPaisConDosFichasQuePasaUnaAOtroSinFichasDejaAmbosPaisesConUnaFicha(){
        Pais paisOrigen = new Pais("Temeria");
        Pais paisDestino = new Pais("Redania");
        List<Ficha> fichas = new ArrayList<>();
        fichas.add(new Ficha());
        fichas.add(new Ficha());

        paisOrigen.agregarFichas(fichas);
        paisOrigen.prepararTropas();

        paisOrigen.moverTropas(paisDestino, 1);

        assertEquals(1, paisOrigen.cantidadFichas());
        assertEquals(1, paisDestino.cantidadFichas());
    }

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
    public void losPaisesPuedenSerNoLimitrofes() {
        Pais pais1 = new Pais("China");
        Pais pais2 = new Pais("Japón");
        Pais pais3 = new Pais("Corea");

        pais1.agregarPaisLimitrofe(pais2);

        assertFalse(pais1.tienePaisLimitrofe(pais3));
        assertFalse(pais2.tienePaisLimitrofe(pais3));
    }

    @Test
    public void unPaisPertenecienteAlJugadorRojoEsRojo() {
        Color rojo = new ColorRojo();
        Jugador j1 = new Jugador("Jugador 1", rojo,canjeador);
        Pais pais = new Pais("Japón");

        j1.agregarPais(pais);

        assertEquals(rojo, pais.getColor());
    }



    @Test
    public void unPaisLimitrofePertenecienteAOtroJugadorEsAtacableSiAmbosTienenFichasSuficientes(){
        Jugador j1 = new Jugador("Jugador 1", new ColorVerde(),canjeador);
        Jugador j2 = new Jugador("Jugador 2", new ColorAmarillo(),canjeador);

        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria");
        paisDefensor = new Pais("Kaedwen");
        paisAtacante.agregarPaisLimitrofe(paisDefensor);
        List<Pais> paisesAtacables = new ArrayList();
        paisesAtacables.add(paisDefensor);

        j1.agregarPais(paisAtacante);
        j2.agregarPais(paisDefensor);
        paisAtacante.agregarFichas(j1.generarFichas(3));
        paisAtacante.agregarFichas(j2.generarFichas(1));

        assertTrue(paisAtacante.getPaisesParaAtacar().equals(paisesAtacables));
    }

    @Test
    public void PaisesLimitrofesPertenecientesAlMismoJugadorSonAliados(){
        Jugador j1 = new Jugador("Jugador 1", new ColorVerde(),canjeador);

        Pais pais1, pais2, pais3;
        pais1 = new Pais("Temeria");
        pais2 = new Pais("Kaedwen");
        pais3 = new Pais("Kaedwen");

        pais1.agregarPaisLimitrofe(pais2);
        pais1.agregarPaisLimitrofe(pais3);

        List<Pais> paisesAliados = new ArrayList();
        paisesAliados.add(pais2);
        paisesAliados.add(pais3);

        j1.agregarPais(pais1);
        j1.agregarPais(pais2);
        j1.agregarPais(pais3);

        assertTrue(pais1.getPaisesLimitrofesAliados().equals(paisesAliados));
    }


    @Test
    public void noSePuedeAtacarAUnPaisAliado() {

        Jugador j1 = new Jugador("Jugador 1", new ColorVerde(),canjeador);

        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria");
        paisDefensor = new Pais("Kaedwen");

        paisAtacante.agregarFichas(j1.generarFichas(2));
        paisDefensor.agregarFichas(j1.generarFichas(2));

        paisAtacante.agregarPaisLimitrofe(paisDefensor);

        j1.agregarPais(paisAtacante);
        j1.agregarPais(paisDefensor);

        Dado unDado = new DadoEstandar();
        Batalla unaBatalla = new Batalla(unDado);

        assertThrows(AtaqueAPaisAliadoException.class,
                ()->{
                    paisAtacante.paisAtacaAPais(paisDefensor, unaBatalla);
                });
    }

    @Test
    public void noSePuedeAtacarAUnPaisNoLimitrofe() {

        Jugador j1 = new Jugador("Jugador 1", new ColorVerde(),canjeador);

        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria");
        paisDefensor = new Pais("Kaedwen");

        paisAtacante.agregarFichas(j1.generarFichas(2));
        paisDefensor.agregarFichas(j1.generarFichas(2));

        j1.agregarPais(paisAtacante);
        j1.agregarPais(paisDefensor);

        Dado unDado = new DadoEstandar();
        Batalla unaBatalla = new Batalla(unDado);

        assertThrows(NoEsLimitrofeException.class,
                ()->{
                    paisAtacante.paisAtacaAPais(paisDefensor, unaBatalla);
                });
    }

    @Test
    public void noSePuedeAtacarConSoloUnaFicha() {

        Jugador j1 = new Jugador("Jugador 1", new ColorVerde(),canjeador);

        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria");
        paisDefensor = new Pais("Kaedwen");

        paisAtacante.agregarFichas(j1.generarFichas(1));
        paisDefensor.agregarFichas(j1.generarFichas(1));

        j1.agregarPais(paisAtacante);
        j1.agregarPais(paisDefensor);

        Dado unDado = new DadoEstandar();
        Batalla unaBatalla = new Batalla(unDado);

        assertThrows(FichasInsuficientesException.class,
                ()->{
                    paisAtacante.paisAtacaAPais(paisDefensor, unaBatalla);
                });
    }


    @Test
    public void ataqueEntreDosPaisesSiDefensorPierdeTodasSusFichasDebeCambiarDeJugador() {

        Jugador j1 = new Jugador("Jugador 1", new ColorVerde(),canjeador);
        Jugador j2 = new Jugador("Jugador 2", new ColorAmarillo(),canjeador);

        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria");
        paisDefensor = new Pais("Kaedwen");

        j1.agregarPais(paisAtacante);
        j2.agregarPais(paisDefensor);

        Dado unDado = mock(Dado.class);
        Batalla batalla = new Batalla(unDado);

        TiradaDeDados tiradaAtacante = new TiradaDeDados();
        tiradaAtacante.agregarResultado(6);
        tiradaAtacante.agregarResultado(6);
        when(unDado.tirarDado(2)).thenReturn(tiradaAtacante);

        TiradaDeDados tiradaDefensor = new TiradaDeDados();
        tiradaDefensor.agregarResultado(2);
        when(unDado.tirarDado(1)).thenReturn(tiradaDefensor);

        paisAtacante.agregarPaisLimitrofe(paisDefensor);

        paisAtacante.agregarFichas(j1.generarFichas(3));
        paisDefensor.agregarFichas(j2.generarFichas(1));

        try {
            paisAtacante.paisAtacaAPais(paisDefensor, batalla);
        } catch (FichasInsuficientesException | NoEsLimitrofeException | AtaqueAPaisAliadoException ataqueInvalidoExcepcion) {
            ataqueInvalidoExcepcion.printStackTrace();
        }
        assertTrue(paisDefensor.conquistadoPorJugador(j1));
    }

    @Test
    public void ataqueEntreDosPaisesSiDefensorNoPierdeTodasSusFichasNoDebeCambiarDeJugador() throws FichasInsuficientesException, NoEsLimitrofeException, AtaqueAPaisAliadoException {
        Jugador j1 = new Jugador("Jugador 1", new ColorVerde(),canjeador);
        Jugador j2 = new Jugador("Jugador 2", new ColorAmarillo(),canjeador);

        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria");
        paisDefensor = new Pais("Kaedwen");

        j1.agregarPais(paisAtacante);
        j2.agregarPais(paisDefensor);

        Dado unDado = mock(Dado.class);
        Batalla batalla = new Batalla(unDado);

        TiradaDeDados tiradaAtacante = new TiradaDeDados();
        tiradaAtacante.agregarResultado(1);
        when(unDado.tirarDado(1)).thenReturn(tiradaAtacante);

        TiradaDeDados tiradaDefensor = new TiradaDeDados();
        tiradaDefensor.agregarResultado(3);
        tiradaDefensor.agregarResultado(4);
        when(unDado.tirarDado(2)).thenReturn(tiradaDefensor);

        paisAtacante.agregarPaisLimitrofe(paisDefensor);

        for (int i = 0; i < 2; i++){
            paisAtacante.agregarFicha(new Ficha());
            paisDefensor.agregarFicha(new Ficha());
        }

        try {
            paisAtacante.paisAtacaAPais(paisDefensor,batalla);
        } catch (FichasInsuficientesException | NoEsLimitrofeException | AtaqueAPaisAliadoException ataqueInvalidoExcepcion) {
            ataqueInvalidoExcepcion.printStackTrace();
        }

        assertFalse(paisDefensor.conquistadoPorJugador(j1));
    }
}
