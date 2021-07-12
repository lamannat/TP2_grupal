package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaisTest {
    @Test
    public void ataqueEntreDosPaisesConDosEjercitos() {
        Pais paisAtacante, paisDefensor;
        paisAtacante = new Pais("Temeria");
        paisDefensor = new Pais("Kaedwen");

        paisAtacante.agregarEjercitos(1);
        paisDefensor.agregarEjercitos(1);

        Dado dado = new Dado(); // despues reemplazar con mockito
        Batalla batalla = new Batalla(paisAtacante, paisDefensor);
        batalla.comenzarBatalla(dado);

        int menorEjercito;

        if(paisAtacante.ejercitos < paisDefensor.ejercitos){
            menorEjercito = paisAtacante.ejercitos;
        }
        else{
            menorEjercito = paisDefensor.ejercitos;
        }

        assertEquals(1, menorEjercito);
    }

}
