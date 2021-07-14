package edu.fiuba.algo3.modelo;

public class Pais {

    private final String nombre;
    private final Limitrofes limitrofes;
    private final Ejercitos ejercitos;

    public Pais(String nombre) {
        this.nombre = nombre;
        this.limitrofes = new Limitrofes();
        this.ejercitos = new Ejercitos();
    }


    public void agregarPaisLimitrofe(Pais pais){
        if (!this.limitrofes.esLimitrofe(pais))
            this.limitrofes.agregarPaisLimitrofe(pais);
        if (!pais.tienePaisLimitrofe(this))
            pais.agregarPaisLimitrofe(this);
    }

    public void agregarEjercitos(int cantidad) {
        ejercitos.agregarEjercitos(cantidad);
    }

    public boolean tienePaisLimitrofe(Pais pais) {
        return this.limitrofes.esLimitrofe(pais);
    }

    private void puedeAtacarAPais(Pais pais) throws AtaqueInvalidoExcepcion {
        boolean puedeAtacar = this.ejercitos.puedeAtacar();
        boolean esLimitrofe = this.limitrofes.esLimitrofe(pais);
        boolean esAleado = esAliado(pais);

        boolean ataqueValido = puedeAtacar && esLimitrofe && !esAleado;

        if (!ataqueValido)
            throw new AtaqueInvalidoExcepcion(puedeAtacar, esLimitrofe, esAleado);
    }

    public boolean puedeAtacar() {
        return this.ejercitos.puedeAtacar();
    }

    public boolean tieneColor(Colores unColor) {
        return this.ejercitos.tieneColor(unColor);
    }

    public boolean esAliado(Pais pais){
        return pais.tieneColor(this.ejercitos.getColor());
    }

    public boolean perteneceAContinente(Continente continente){
        return continente.tienePais(this);
    }

    public void setColor(Colores color){
        ejercitos.setColor(color);
    }

    public void seDefiendeDe(Ejercitos ejercitoAtacante) {
        Batalla.ejercitoAtacaAEjercito(ejercitoAtacante, this.ejercitos);
    }

    public void paisAtacaAPais(Pais paisDefensor) throws AtaqueInvalidoExcepcion {
        puedeAtacarAPais(paisDefensor);
        paisDefensor.seDefiendeDe(this.ejercitos);
    }

    public boolean tieneNombre(String unNombre){
        return (this.nombre == unNombre);
    }
}



