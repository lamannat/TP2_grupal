package edu.fiuba.algo3;

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

public class NombresYColores {

    Integer cantJugadores;

    public void setCantJugadores(Integer n){
        cantJugadores = n;
    }

    public Scene crearJugadores(Stage ventana, Scene mapa){
        HBox hbox = new HBox();

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el nombre del Jugador");
        texto.setScaleX(5);
        texto.setScaleY(3);

        Button botonSiguiente = new Button();
        botonSiguiente.setText("Siguiente Jugador");
        botonSiguiente.setScaleX(5);
        botonSiguiente.setScaleY(5);

        hbox.setSpacing(200.0);
//        texto.setAlignment(Pos.CENTER);
//        botonSiguiente.setAlignment(Pos.BOTTOM_CENTER);

        hbox.getChildren().addAll(texto, botonSiguiente);


        AnchorPane anchor = new AnchorPane();
        anchor.getChildren().add(hbox);
        anchor.setMinSize(310.0,310.0);
        AnchorPane.setLeftAnchor(hbox,10.0);

//        Label label = new Label();

        botonSiguiente.setOnAction(e -> {
            if (texto.getText().trim().equals("")) {
                System.out.println("mal :(");
//                anchor.getChildren().add(label);
//                label.setText("Debe ingresar un nombre");
//                label.setTextFill(Color.RED);
//                texto.requestFocus();
//                label.setScaleX(3);
//                label.setScaleY(3);
//                anchor.getChildren().add(label);

            }
            //if (no se cliqueo lo de colores)
            else {
//                label.setText(texto.getText());
//                label.setTextFill(Color.DARKGREEN);
            }
        });



        Scene sceneJugadores = new Scene(anchor);

        return sceneJugadores;
//        for (int i = 0; i<cantJugadores; i++){
//            ventana.setScene(sceneJugadores);
//
//        }
    }
}
