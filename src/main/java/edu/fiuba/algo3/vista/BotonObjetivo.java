package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.objetivos.Objetivo;
import edu.fiuba.algo3.modelo.objetivos.ObjetivoCompuesto;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonObjetivo extends Button {
    String listaObjetivos = "";

    public BotonObjetivo(){
        this.setText("Objetivo");
        this.setStyle("-fx-focus-color: transparent;");


        this.setOnAction(e -> {
            Label label = new Label(listaObjetivos);
            label.setTextFill(Color.WHITE);
            label.setStyle("-fx-font-size: 20");

            StackPane layout = new StackPane();
            layout.getChildren().add(label);
            layout.setStyle("-fx-background-color: #272727");

            Scene nuevaEscena = new Scene(layout, 450,300);

            // New window (Stage)
            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("Objetivo");
            nuevaVentana.setScene(nuevaEscena);

            nuevaVentana.show();
        });
    }

    public void actualizar(Jugador jugador){
        Objetivo objetivoCompuesto = jugador.getObjetivoCompuesto();
        this.listaObjetivos = objetivoCompuesto.toString();
    }
}
