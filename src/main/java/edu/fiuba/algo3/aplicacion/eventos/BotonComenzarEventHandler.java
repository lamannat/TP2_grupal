package edu.fiuba.algo3.aplicacion.eventos;

import edu.fiuba.algo3.aplicacion.app.App;
import edu.fiuba.algo3.aplicacion.app.VistaSeleccionarCantidadJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class BotonComenzarEventHandler implements EventHandler<ActionEvent> {

    private App app;

    public BotonComenzarEventHandler(App app) {
        this.app = app;
    }

    @Override
    public void handle(ActionEvent arg0) {
        Scene escena = new Scene(new VistaSeleccionarCantidadJugadores(app));
        File estilo = new File ("src/main/java/edu/fiuba/algo3/aplicacion/css/name-screen.css");
        escena.getStylesheets().add(estilo.toURI().toString());
        app.setScene(escena);
    }
}
