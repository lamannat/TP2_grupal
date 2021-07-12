package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaisTest {

    @Test
    public void PaisConquistaAOtroPais(){
        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria", Colores.VERDE);
        paisDefensor = new Pais("Kaedwen", Colores.AMARILLO);

        paisAtacante.agregarEjercitos(1);
        paisDefensor.agregarEjercitos(1);

        paisDefensor.conquistadoPor(paisAtacante);

        assertTrue(paisDefensor.tieneColor(Colores.VERDE));
    }

    @Test
    public void ataqueEntreDosPaisesGanaAtacanteConMockito(){
        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria", Colores.VERDE);
        paisDefensor = new Pais("Kaedwen", Colores.AMARILLO);

        paisAtacante.agregarEjercitos(3);
        paisDefensor.agregarEjercitos(1);

        paisAtacante.agregarPaisLimitrofe(paisDefensor);
        paisDefensor.agregarPaisLimitrofe(paisAtacante);

        Dado dado = mock(Dado.class); // mockito
        Batalla batalla = new Batalla(paisDefensor, paisAtacante);

        List<Integer> numsDadosAtacante = new ArrayList<>();
        List<Integer> numsDadosDefensor = new ArrayList<>();
        numsDadosAtacante.add(6);
        numsDadosAtacante.add(6);
        numsDadosAtacante.add(6);

        numsDadosDefensor.add(1);
        numsDadosDefensor.add(1);

        when(dado.tirarDados(3)).thenReturn(numsDadosAtacante);
        when(dado.tirarDados(2)).thenReturn(numsDadosDefensor);
        batalla.comenzarBatalla(dado);

        assertTrue(paisDefensor.tieneColor(Colores.VERDE));
    }

    @Test
    public void ataqueEntreDosPaisesAtacanteNoConquistaConMockito(){
        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria", Colores.VERDE);
        paisDefensor = new Pais("Kaedwen", Colores.AMARILLO);

        paisAtacante.agregarEjercitos(1);
        paisDefensor.agregarEjercitos(1);

        paisAtacante.agregarPaisLimitrofe(paisDefensor);
        paisDefensor.agregarPaisLimitrofe(paisAtacante);

        Dado dado = mock(Dado.class); // mockito
        Batalla batalla = new Batalla(paisDefensor, paisAtacante);

        List<Integer> numsDados = new ArrayList<>();
        numsDados.add(6);
        numsDados.add(3);

        when(dado.tirarDados(2)).thenReturn(numsDados);
        batalla.comenzarBatalla(dado);

        assertTrue(paisDefensor.tieneColor(Colores.AMARILLO));
    }


}
