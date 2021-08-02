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

        Button boton2 = new Button("2");
        Button boton3 = new Button("3");
        Button boton4 = new Button("4");
        Button boton5 = new Button("5");
        Button boton6 = new Button("6");

        List<Button> botones = new ArrayList<>();
        botones.add(boton2);
        botones.add(boton3);
        botones.add(boton4);
        botones.add(boton5);
        botones.add(boton6);

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


        boton2.setOnAction(new BotonCantidadEventHandler(setUp, 2, botonSiguiente));
        boton3.setOnAction(new BotonCantidadEventHandler(setUp, 3, botonSiguiente));
        boton4.setOnAction(new BotonCantidadEventHandler(setUp, 4, botonSiguiente));
        boton5.setOnAction(new BotonCantidadEventHandler(setUp, 5, botonSiguiente));
        boton6.setOnAction(new BotonCantidadEventHandler(setUp, 6, botonSiguiente));

        boton2.setOnMouseClicked(e-> {
            botones.forEach(this::estiloBotonDefault);
            this.estiloBotonSeleccionado(boton2);
        });

        boton3.setOnMouseClicked(e-> {
            botones.forEach(this::estiloBotonDefault);
            this.estiloBotonSeleccionado(boton3);
        });

        boton4.setOnMouseClicked(e-> {
            botones.forEach(this::estiloBotonDefault);
            this.estiloBotonSeleccionado(boton4);
        });

        boton5.setOnMouseClicked(e-> {
            botones.forEach(this::estiloBotonDefault);
            this.estiloBotonSeleccionado(boton5);
        });

        boton6.setOnMouseClicked(e-> {
            botones.forEach(this::estiloBotonDefault);
            this.estiloBotonSeleccionado(boton6);
        });

        this.setSpacing(200.0);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(boton2,boton3,boton4,boton5,boton6);
    }

    private void estiloBotonDefault(Button unBoton) {
        unBoton.setStyle("-fx-background-color: black");
    }

    private void estiloBotonSeleccionado(Button unBoton) {
        unBoton.setStyle("-fx-border-color: #ffcc3d;-fx-background-color: #000000");
    }
}
