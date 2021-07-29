package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VistaSetearCantidadJugadores {

    public Scene crearCantJugadores(Stage ventana, Scene sceneNombresColores){
        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: #272727");

        Button boton2 = new Button("2");
        Button boton3 = new Button("3");
        Button boton4 = new Button("4");
        Button boton5 = new Button("5");
        Button boton6 = new Button("6");

        boton2.setScaleX(3);
        boton2.setScaleY(3);
        boton3.setScaleX(3);
        boton3.setScaleY(3);
        boton4.setScaleX(3);
        boton4.setScaleY(3);
        boton5.setScaleX(3);
        boton5.setScaleY(3);
        boton6.setScaleX(3);
        boton6.setScaleY(3);

        boton2.setStyle("-fx-background-color: black");
        boton2.setTextFill(Color.WHITE);
        boton2.setAlignment(Pos.CENTER);

        boton3.setStyle("-fx-background-color: black");
        boton3.setTextFill(Color.WHITE);
        boton3.setAlignment(Pos.CENTER);

        boton4.setStyle("-fx-background-color: black");
        boton4.setTextFill(Color.WHITE);
        boton4.setAlignment(Pos.CENTER);

        boton5.setStyle("-fx-background-color: black");
        boton5.setTextFill(Color.WHITE);
        boton5.setAlignment(Pos.CENTER);

        boton6.setStyle("-fx-background-color: black");
        boton6.setTextFill(Color.WHITE);
        boton6.setAlignment(Pos.CENTER);

        //acordarse de que solo se puede cliquear UN boton
        boton2.setOnAction(e -> {
            System.out.println("2");
            ventana.setScene(sceneNombresColores);
        });
        boton3.setOnAction(e -> {
            System.out.println("3");
            ventana.setScene(sceneNombresColores);
        });
        boton4.setOnAction(e -> {
            System.out.println("4");
            ventana.setScene(sceneNombresColores);
        });
        boton5.setOnAction(e -> {
            System.out.println("5");
            ventana.setScene(sceneNombresColores);
        });
        boton6.setOnAction(e -> {
            System.out.println("6");
            ventana.setScene(sceneNombresColores);
        });

        hbox.setSpacing(200.0);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(boton2,boton3,boton4,boton5,boton6);

        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: #272727");
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(200.0);

        Label textoCantidadJugadores = new Label("¿Cuántos juegan?");
        textoCantidadJugadores.setScaleX(10);
        textoCantidadJugadores.setScaleY(10);
        textoCantidadJugadores.setTextFill(Color.YELLOW);

        vbox.getChildren().addAll(textoCantidadJugadores,hbox);
        Scene sceneCantJugadores = new Scene(vbox);

        return sceneCantJugadores;

    }
}
