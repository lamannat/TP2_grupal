package edu.fiuba.algo3.modelo;

public class AtaqueInvalidoExcepcion extends Exception {

    public boolean sePuedeAtacar;
    public boolean esLimitrofe;
    public boolean esAleado;

    public AtaqueInvalidoExcepcion(boolean sePudoAtacar, boolean esLimitrofe, boolean esAleado) {
        if (!sePudoAtacar)
            System.out.println("no se pudo atacar"); // recordatorio de hacer una excepcion
        if (!esLimitrofe)
            System.out.println("no es limitro");
        if (esAleado)
            System.out.println("estas atacando un aleado");
        this.sePuedeAtacar = sePudoAtacar;
        this.esLimitrofe = esLimitrofe;
        this.esAleado = esAleado;
    }
}
