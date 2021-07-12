package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaisTest {
    @Test
    public void ataqueEntreDosPaisesConDosEjercitos() {
        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria", Colores.VERDE);
        paisDefensor = new Pais("Kaedwen", Colores.AMARILLO);

        paisAtacante.agregarEjercitos(1);
        paisDefensor.agregarEjercitos(1);

        paisAtacante.agregarPaisLimitrofe(paisDefensor);
        paisDefensor.agregarPaisLimitrofe(paisAtacante);

        Dado dado = new Dado(); // despues reemplazar con mockito
        Batalla batalla = new Batalla(paisAtacante, paisDefensor);
        batalla.comenzarBatalla(dado);

        int menorEjercito;
        Ejercitos ejercitoAtacante = paisAtacante.atacoConEjercito();
        Ejercitos ejercitoDefensor = paisDefensor.atacoConEjercito();

        if(ejercitoAtacante.ejercitos < ejercitoDefensor.ejercitos){
            menorEjercito = ejercitoAtacante.ejercitos;
        }
        else{
            menorEjercito = ejercitoDefensor.ejercitos;
        }

        assertEquals(1, menorEjercito);
    }

}
