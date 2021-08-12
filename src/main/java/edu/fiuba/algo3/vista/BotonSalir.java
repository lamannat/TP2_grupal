package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonSalir extends Button {

    public BotonSalir(Stage ventana) {
        this.setText("Salir");
        this.getStyleClass().addAll("botonJuego", "hoverOscuro");
        this.setAlignment(Pos.CENTER);
        this.setOnAction(e -> {
            ventana.close();
        });
    }
}