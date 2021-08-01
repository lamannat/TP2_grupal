package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Escena extends Scene {

    protected final ControladorDeEscena controladorDeEscena;
    protected final Juego juego;

    public Escena(Parent padre, ControladorDeEscena controladorDeEscena, Juego juego) {
        super(padre);
        this.controladorDeEscena = controladorDeEscena;
        this.juego = juego;
    }

    public abstract void mostrar(Stage ventana);
}
