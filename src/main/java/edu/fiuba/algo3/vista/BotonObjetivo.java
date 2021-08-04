package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.objetivos.Objetivo;
import edu.fiuba.algo3.modelo.objetivos.ObjetivoCompuesto;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonObjetivo extends Button {

    public BotonObjetivo(Juego juego){
        this.setText("Objetivo");
        Objetivo objetivoCompuesto = juego.jugadorActual().getObjetivoCompuesto();
        String  listaObjetivos = objetivoCompuesto.toString();
        System.out.println(listaObjetivos);

        this.setOnAction(e -> {
            Label label = new Label(listaObjetivos);
            label.setPrefSize(200,200);
            label.setMaxSize(200,200);
            label.setMinSize(200,200);
            label.setTextFill(Color.WHITE);

            StackPane layout = new StackPane();
            layout.getChildren().add(label);
            layout.setStyle("-fx-background-color: #272727");

            Scene nuevaEscena = new Scene(layout, 400,300);

            // New window (Stage)
            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("Objetivo");
            nuevaVentana.setScene(nuevaEscena);

            nuevaVentana.show();
        });
    }
}
