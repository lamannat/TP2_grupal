package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.color.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonDeColor extends Button {
    private Color color;

    public BotonDeColor(Color unColor){
        this.color = unColor;
        this.setText(color.getNombre());
        this.setStyle("-fx-background-color: " + color.getCodigo());
        this.setScaleX(3);
        this.setScaleY(3);
    }

    public void enAccion(BotonColorEventHandler eventHandler){
        eventHandler.setColor(color);
        this.setOnAction(eventHandler);
        eventHandler.setColorSeleccionado(this);
    }
}
