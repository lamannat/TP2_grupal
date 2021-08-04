package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class ObjetivoCompuesto implements Objetivo{
    private List<Objetivo> objetivos;

    public ObjetivoCompuesto(List<Objetivo> objetivos) {
        this.objetivos = objetivos;
    }

    @Override
    public boolean cumplido() {
        return objetivos.stream().allMatch(Objetivo::cumplido) ;
    }

    @Override
    public String toString(){
        String objetivoCompuesto = "OBJETIVOS:\n";

        for (Objetivo objetivo: objetivos){
            objetivoCompuesto += "- " + objetivo.toString() + "\n";
        }

        return objetivoCompuesto;
    }
}
