package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonSiguienteEscenaEventHandler;
import edu.fiuba.algo3.controlador.ControladorDeEscena;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonSiguiente extends Button {
    public BotonSiguiente(Stage ventana, ControladorDeEscena controladorDeEscena) {
        this.setOnAction(new BotonSiguienteEscenaEventHandler(ventana, controladorDeEscena));
        this.setScaleX(2);
        this.setScaleY(2);
        this.setStyle("-fx-background-color:black");
        this.setTextFill(Color.WHITE);
        this.setText("Siguiente");
        this.setAlignment(Pos.BOTTOM_RIGHT);
    }
}
