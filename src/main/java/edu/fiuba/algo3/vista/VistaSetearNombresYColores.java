package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VistaSetearNombresYColores {

    Integer cantJugadores;

    public void setCantJugadores(Integer n){
        cantJugadores = n;
    }

    public Scene crearJugadores(Stage ventana, Scene mapa){
        HBox hbox1 = new HBox();
        hbox1.setStyle("-fx-background-color: #272727");

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el nombre del Jugador");
        texto.setScaleX(2);
        texto.setScaleY(2);

        //azul, amarillo, rojo, verde, magenta, negro

        Button botonColorAzul = new Button("Azul");
        Button botonColorRojo = new Button("Rojo");
        Button botonColorVerde = new Button("Verde");
        Button botonColorMagenta = new Button("Magenta");
        Button botonColorNegro = new Button("Negro");
        Button botonColorAmarillo = new Button("Amarillo");

        Button botonSiguiente = new Button();
        botonSiguiente.setText("Siguiente Jugador");
        botonSiguiente.setScaleX(3);
        botonSiguiente.setScaleY(3);

        hbox1.setSpacing(320.0);
        hbox1.setAlignment(Pos.CENTER);

        hbox1.getChildren().addAll(texto,botonSiguiente);

        HBox hbox2 = new HBox();
        hbox2.setStyle("-fx-background-color: #272727");

        botonColorAzul.setScaleX(3);
        botonColorAzul.setScaleY(3);
        botonColorRojo.setScaleX(3);
        botonColorRojo.setScaleY(3);
        botonColorVerde.setScaleX(3);
        botonColorVerde.setScaleY(3);
        botonColorMagenta.setScaleX(3);
        botonColorMagenta.setScaleY(3);
        botonColorNegro.setScaleX(3);
        botonColorNegro.setScaleY(3);
        botonColorAmarillo.setScaleX(3);
        botonColorAmarillo.setScaleY(3);

        botonColorAzul.setStyle("-fx-background-color: #0077bb");
        botonColorAzul.setTextFill(Color.WHITE);
        botonColorRojo.setStyle("-fx-background-color: #cc3311");
        botonColorRojo.setTextFill(Color.WHITE);
        botonColorVerde.setStyle("-fx-background-color: #009988");
        botonColorVerde.setTextFill(Color.WHITE);
        botonColorMagenta.setStyle("-fx-background-color: #ee3377");
        botonColorMagenta.setTextFill(Color.WHITE);
        botonColorNegro.setStyle("-fx-background-color: #000000");
        botonColorNegro.setTextFill(Color.WHITE);
        botonColorAmarillo.setStyle("-fx-background-color: #ee7733");
        botonColorAmarillo.setTextFill(Color.BLACK);

        hbox2.getChildren().addAll(botonColorAzul,botonColorAmarillo,botonColorMagenta,botonColorNegro,botonColorRojo,botonColorVerde);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.setSpacing(200);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(100.0);
        vbox.getChildren().addAll(hbox1,hbox2);
        vbox.setMinSize(110.0,110.0);
        vbox.setStyle("-fx-background-color: #272727");

//        Label label = new Label();

        botonSiguiente.setOnAction(e -> {
            if (texto.getText().trim().equals("")) {
                System.out.println("mal :(");
//                vbox.getChildren().add(label);
//                label.setText("Debe ingresar un nombre");
//                label.setTextFill(Color.RED);
//                texto.requestFocus();
//                label.setScaleX(3);
//                label.setScaleY(3);
//                vbox.getChildren().add(label);

            }
            //if (no se cliqueo lo de colores)
            else {
//                label.setText(texto.getText());
//                label.setTextFill(Color.DARKGREEN);
            }
        });



        Scene sceneJugadores = new Scene(vbox);

        return sceneJugadores;
//        for (int i = 0; i<cantJugadores; i++){
//            ventana.setScene(sceneJugadores);
//
//        }
    }
}
