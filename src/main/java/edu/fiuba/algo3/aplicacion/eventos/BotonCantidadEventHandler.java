package edu.fiuba.algo3.aplicacion.eventos;

import edu.fiuba.algo3.aplicacion.app.App;
import edu.fiuba.algo3.aplicacion.app.VistaIngresarJugadores;
import edu.fiuba.algo3.aplicacion.app.VistaSeleccionarCantidadJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import java.io.File;

public class BotonCantidadEventHandler implements EventHandler<ActionEvent> {

    private int cantidad;
    private App app;

    public BotonCantidadEventHandler(App app, int cantidad) {
        this.cantidad = cantidad;
        this.app = app;
    }

    public void handle(ActionEvent event) {
        Scene escena = new Scene(new VistaIngresarJugadores(this.app, this.cantidad));
        File estilo = new File ("src/main/java/edu/fiuba/algo3/aplicacion/css/name-screen.css");
        escena.getStylesheets().add(estilo.toURI().toString());
        app.setScene(escena);
        app.getSetup().setCantidadJugadores(this.cantidad);
    }
}
