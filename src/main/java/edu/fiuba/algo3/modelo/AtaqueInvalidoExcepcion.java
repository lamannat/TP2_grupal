package edu.fiuba.algo3.modelo;

public class AtaqueInvalidoExcepcion extends Exception {

    public AtaqueInvalidoExcepcion(boolean sePudoAtacar, boolean esLimitrofe, boolean esAliado) throws NoEsLimitrofeException, FichasInsuficientesException, AtaqueAPaisAliadoException {
        if (!sePudoAtacar)
            throw new FichasInsuficientesException();
        if (!esLimitrofe)
            throw new NoEsLimitrofeException();
        if (esAliado)
            throw new AtaqueAPaisAliadoException();
    }
}
