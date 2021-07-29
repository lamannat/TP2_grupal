package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaSetearCantidadJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {
    Stage ventana;

    public BotonJugarEventHandler(Stage ventana) {
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaSetearCantidadJugadores siguienteVista = new VistaSetearCantidadJugadores();
        Scene nuevaEscena = siguienteVista.crearCantJugadores(ventana);
        ventana.setScene(nuevaEscena);
    }
}
