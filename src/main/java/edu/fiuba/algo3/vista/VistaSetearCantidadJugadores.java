package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.SetUpJuego;
import edu.fiuba.algo3.controlador.ControladorDeEscena;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VistaSetearCantidadJugadores extends Escena {

    private final VBox padre;
    private final SetUpJuego setUp;

    public VistaSetearCantidadJugadores(Parent padre, ControladorDeEscena controladorDeEscena, SetUpJuego setUp) {
        super(padre, controladorDeEscena);
        this.padre = (VBox) padre;
        this.setUp = setUp;
    }

    public void mostrar(Stage ventana) {
        padre.getChildren().clear();

        this.padre.setPrefWidth(controladorDeEscena.getResolucionAncho());
        this.padre.setPrefHeight(controladorDeEscena.getResolucionAlto());

        BotonSiguiente botonSiguiente = new BotonSiguiente(ventana, this.controladorDeEscena);
        botonSiguiente.setVisible(false);

        BotoneraCantidadJugadores botonera = new BotoneraCantidadJugadores(botonSiguiente, setUp);

        padre.setStyle("-fx-background-color: #272727");
        padre.setAlignment(Pos.CENTER);
        padre.setSpacing(100.0);

        Label textoCantidadJugadores = new Label("¿Cuántos Juegan?");
        textoCantidadJugadores.setStyle("-fx-font-size: 100px;");
        textoCantidadJugadores.setTextFill(Color.valueOf("#ffcc3d"));
        textoCantidadJugadores.setAlignment(Pos.CENTER);

        padre.getChildren().addAll(textoCantidadJugadores, botonera, botonSiguiente);
    }
}
