package edu.fiuba.algo3.aplicacion.app;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NombresYColores {

    Integer cantJugadores;

    public void setCantJugadores(Integer n){
        cantJugadores = n;
    }

    public Scene crearJugadores(Stage ventana, Scene mapa){
        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: yellow");

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el nombre del Jugador");
        texto.setScaleX(2);
        texto.setScaleY(2);

        Button botonSiguiente = new Button();
        botonSiguiente.setText("Siguiente Jugador");
        botonSiguiente.setScaleX(3);
        botonSiguiente.setScaleY(3);

        hbox.setSpacing(320.0);
        hbox.setAlignment(Pos.CENTER);

        hbox.getChildren().addAll(texto,botonSiguiente);


        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(100.0);
        vbox.getChildren().add(hbox);
        vbox.setMinSize(110.0,110.0);
        vbox.setStyle("-fx-background-color: yellow");

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
