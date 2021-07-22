package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.*;

import java.util.ArrayList;
import java.util.List;

public class GeneradorFichas {
    public static List<Ficha> generar(Integer cantFichas, Color color){
        List<Ficha> fichas = new ArrayList<>();

        for (int i = 0; i<cantFichas; i++){
            fichas.add(new Ficha(color));
        }
        return fichas;
    }
}
