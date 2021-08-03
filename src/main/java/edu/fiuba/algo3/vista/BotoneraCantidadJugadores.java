package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonCantidadEventHandler;
import edu.fiuba.algo3.modelo.SetUpJuego;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class BotoneraCantidadJugadores extends HBox {

    public BotoneraCantidadJugadores(Button botonSiguiente, SetUpJuego setUp) {

        // Configuración Botonera

        this.setStyle("-fx-background-color: #272727");

        List<Button> botones = new ArrayList<>();
        botones.add(new Button("2"));
        botones.add(new Button("3"));
        botones.add(new Button("4"));
        botones.add(new Button("5"));
        botones.add(new Button("6"));

        for (int i = 0; i < botones.size(); i++)
        {
            Button boton = botones.get(i);
            int numero = i + 2;

            boton.setScaleX(3);
            boton.setScaleY(3);

            boton.setStyle("-fx-background-color: black");
            boton.setTextFill(Color.WHITE);
            boton.setAlignment(Pos.CENTER);

            boton.setOnAction(new BotonCantidadEventHandler(setUp, numero, botonSiguiente));

            boton.setOnMouseClicked(e-> {
                botones.forEach(this::estiloBotonDefault);
                this.estiloBotonSeleccionado(boton);
            });
        }

        this.setSpacing(200.0);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(botones);
    }

    private void estiloBotonDefault(Button unBoton) {
        unBoton.setStyle("-fx-background-color: black");
    }

    private void estiloBotonSeleccionado(Button unBoton) {
        unBoton.setStyle("-fx-border-color: #ffcc3d;-fx-background-color: #000000");
    }
}
