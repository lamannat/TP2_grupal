package edu.fiuba.algo3.modelo.color;

public abstract class Color {
    protected int codigo = 0;

    boolean tieneColor(Color color) {
        return this.codigo == color.codigo;
    }
}
