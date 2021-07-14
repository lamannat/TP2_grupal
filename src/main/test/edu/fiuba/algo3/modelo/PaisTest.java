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
        Pais pais = new Pais("Temeria", Colores.VERDE);
        assertFalse(pais.puedeAtacar());
    }

    @Test
    public void paisEmpiezaConUnaFichaPuedeAtacarSiSeAgregaFicha(){
        Pais pais = new Pais("Temeria", Colores.VERDE);
        pais.agregarEjercitos(1);
        assertTrue(pais.puedeAtacar());
    }

    @Test
    public void agregarUnPaisLimitrofeHaceAlPaisAgregadoLimitrofe(){
        Pais pais = new Pais("Temeria", Colores.VERDE);
        Pais paisLimitrofe = new Pais("Redania", Colores.VERDE);
        pais.agregarPaisLimitrofe(paisLimitrofe);
        assertTrue(pais.tienePaisLimitrofe(paisLimitrofe));
    }

    @Test
    public void agregarUnPaisLimitrofeHaceAlPaisAgregadoLimitrofeReciprocamente(){
        Pais pais = new Pais("Temeria", Colores.VERDE);
        Pais paisLimitrofe = new Pais("Redania", Colores.VERDE);
        pais.agregarPaisLimitrofe(paisLimitrofe);
        assertTrue(paisLimitrofe.tienePaisLimitrofe(pais));
    }
//
//    @Test
//    public void ataqueEntreDosPaisesSiDefensorPierdeTodasSusFichasDebeCambiarDeColor(){
//        Pais paisAtacante, paisDefensor;
//        paisAtacante = new Pais("Temeria", Colores.VERDE);
//        paisDefensor = new Pais("Kaedwen", Colores.AMARILLO);
//
//        paisAtacante.agregarEjercitos(3);
//        paisDefensor.agregarEjercitos(1);
//
//        paisAtacante.agregarPaisLimitrofe(paisDefensor);
//
//        Dado dado = mock(Dado.class); // mockito
//
//        List<Integer> numsDadosAtacante = new ArrayList<>();
//        List<Integer> numsDadosDefensor = new ArrayList<>();
//        numsDadosAtacante.add(6);
//        numsDadosAtacante.add(6);
//        numsDadosAtacante.add(6);
//
//        numsDadosDefensor.add(1);
//        numsDadosDefensor.add(1);
//
//        when(dado.tirarDados(3)).thenReturn(numsDadosAtacante);
//        when(dado.tirarDados(2)).thenReturn(numsDadosDefensor);
//
//        paisAtacante.atacaPais(paisDefensor, dado);
//
//        assertTrue(paisDefensor.tieneColor(Colores.VERDE));
//    }

//    @Test
//    public void ataqueEntreDosPaisesSiAtacantePierdeElDefensorMantieneSuColor(){
//        Pais paisAtacante, paisDefensor;
//        paisAtacante = new Pais("Temeria", Colores.VERDE);
//        paisDefensor = new Pais("Kaedwen", Colores.AMARILLO);
//
//        paisAtacante.agregarEjercitos(1);
//        paisDefensor.agregarEjercitos(1);
//
//        paisAtacante.agregarPaisLimitrofe(paisDefensor);
//
//        Dado dado = mock(Dado.class); // mockito
//
//        List<Integer> numsDados = new ArrayList<>();
//        numsDados.add(6);
//        numsDados.add(3);
//
//        when(dado.tirarDados(2)).thenReturn(numsDados);
//        paisAtacante.atacaPais(paisDefensor, dado);
//
//        assertTrue(paisDefensor.tieneColor(Colores.AMARILLO));
//    }

    @Test
    public void ataqueEntreDosPaisesSiDefensorPierdeTodasSusFichasDebeCambiarDeColor(){
        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria", Colores.VERDE);
        paisDefensor = new Pais("Kaedwen", Colores.AMARILLO);

        paisAtacante.agregarPaisLimitrofe(paisDefensor);
        paisAtacante.agregarEjercitos(20);

        assertThrows(AtaqueInvalidoExcepcion.class, //En el primer o segundo ataque el pais va a ser conquistado, luego de eso los ataques lanzan la excepcion.
                ()->{
                    paisAtacante.paisAtacaAPais(paisDefensor);
                    paisAtacante.paisAtacaAPais(paisDefensor);
                    paisAtacante.paisAtacaAPais(paisDefensor);
                    paisAtacante.paisAtacaAPais(paisDefensor);
                    paisAtacante.paisAtacaAPais(paisDefensor);
                });
        assertTrue(paisDefensor.tieneColor(Colores.VERDE)); //cambia de color porque despues de 5 ataques seguro perdio
    }


}
