package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.Escena;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonSiguienteEscenaEventHandler implements EventHandler<ActionEvent> {
    private final ControladorDeEscena controladorDeEscena;
    Stage ventana;

    public BotonSiguienteEscenaEventHandler(Stage ventana, ControladorDeEscena controladorDeEscena) {
        this.ventana = ventana;
        this.controladorDeEscena = controladorDeEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Escena siguienteEscena = controladorDeEscena.siguienteEscena();
        siguienteEscena.mostrar(ventana);
        ventana.setScene(siguienteEscena);
    }
}
