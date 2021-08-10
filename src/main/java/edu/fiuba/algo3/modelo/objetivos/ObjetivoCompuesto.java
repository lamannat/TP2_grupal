package edu.fiuba.algo3.modelo.objetivos;

import java.util.List;

public class ObjetivoCompuesto implements Objetivo{
    private final List<Objetivo> objetivos;

    public ObjetivoCompuesto(List<Objetivo> objetivos) {
        this.objetivos = objetivos;
    }

    @Override
    public boolean cumplido() {
        return objetivos.stream().allMatch(Objetivo::cumplido) ;
    }

    @Override
    public String toString() {
        return objetivos.stream().reduce("OBJETIVOS:\n", (total, especifico) -> total + "- " + especifico.toString() + "\n", String::concat);
    }
}
