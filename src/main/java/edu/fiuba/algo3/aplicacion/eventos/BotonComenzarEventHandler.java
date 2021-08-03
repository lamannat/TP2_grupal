package edu.fiuba.algo3.aplicacion.eventos;

import edu.fiuba.algo3.aplicacion.app.App;
import edu.fiuba.algo3.aplicacion.app.VistaSeleccionarCantidadJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonComenzarEventHandler implements EventHandler<ActionEvent> {

    private Stage ventana;
    Integer cantJugadores;

    public BotonComenzarEventHandler(Stage ventana) {
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent arg0) {
        new VistaSeleccionarCantidadJugadores(this.ventana, 1280, 720);
    }
}
