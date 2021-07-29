package edu.fiuba.algo3.controlador;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.ArrayList;

public class BotonSiguiente extends Button {
    private final int cantJugadores;

    public BotonSiguiente(int cantJugadores) {
        this.cantJugadores = cantJugadores;
        this.setText("Siguiente Jugador");
        this.setTextFill(Color.BLACK);
        this.setStyle("-fx-background-color: white");
        this.setScaleX(3);
        this.setScaleY(3);
    }
}
