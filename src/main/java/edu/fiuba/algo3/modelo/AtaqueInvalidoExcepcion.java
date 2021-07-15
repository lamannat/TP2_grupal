package edu.fiuba.algo3.modelo;

public class AtaqueInvalidoExcepcion extends Exception {

    public AtaqueInvalidoExcepcion(boolean sePudoAtacar, boolean esLimitrofe, boolean esAliado) throws NoEsLimitrofeException, EjercitosInsuficientesException, AtaqueAPaisAliadoException {
        if (!sePudoAtacar)
            throw new EjercitosInsuficientesException();
        if (!esLimitrofe)
            throw new NoEsLimitrofeException();
        if (esAliado)
            throw new AtaqueAPaisAliadoException();
    }
}
