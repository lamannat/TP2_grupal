package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaTitulo {

    public Scene crearTitulo(Stage ventana, Scene segunda){
        Button botonJugar;
        Scene primera;

        // ALTEGO
        Label altego = new Label("A.L.T.E.G.O");
        altego.setScaleX(20);
        altego.setScaleY(20);
        altego.setTextFill(Color.YELLOW);
        Font font = new Font(10);
        altego.setFont(font);

        // BOTON JUGAR
        botonJugar = new Button("JUGAR");
        botonJugar.setStyle("-fx-background-color: black");
        botonJugar.setTextFill(Color.WHITE);
        botonJugar.setScaleX(5);
        botonJugar.setScaleY(5);
        botonJugar.setOnAction(e -> {
            ventana.setScene(segunda);
        });

        // LAYOUT INICIAL
        VBox layout1 = new VBox(250);
        layout1.getChildren().addAll(altego, botonJugar);
        layout1.setAlignment(Pos.CENTER);
        layout1.setStyle("-fx-background-color: #272727");
        primera = new Scene(layout1, 500, 100);

        return primera;
    }


}
