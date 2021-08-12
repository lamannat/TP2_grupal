package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeEscena;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Escena extends Scene {

    protected final ControladorDeEscena controladorDeEscena;

    public Escena(Parent padre, ControladorDeEscena controladorDeEscena) {
        super(padre);
        this.controladorDeEscena = controladorDeEscena;
        String css = this.getClass().getResource("/css/estiloSidePanel.css").toExternalForm();
        String css2 = this.getClass().getResource("/css/estiloBotones.css").toExternalForm();
        this.getStylesheets().addAll(css, css2);
    }

    public abstract void mostrar(Stage ventana);
}
