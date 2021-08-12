package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonSiguienteEscenaEventHandler;
import edu.fiuba.algo3.controlador.ControladorDeEscena;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonJugar extends Button {

    public BotonJugar(Stage ventana, ControladorDeEscena controladorDeEscena) {
        this.setOnAction(new BotonSiguienteEscenaEventHandler(ventana, controladorDeEscena));
        this.setText("Jugar");
        this.getStyleClass().addAll("botonJuego", "hoverOscuro");
        this.setAlignment(Pos.CENTER);
    }
}
