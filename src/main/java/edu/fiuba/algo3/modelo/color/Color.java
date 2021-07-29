package edu.fiuba.algo3.modelo.color;

public abstract class Color {
    protected String codigo;

    public boolean tieneColor(Color color) {
        return this.codigo == color.codigo;
    }

    public String getCodigo(){ return this.codigo; }
}
