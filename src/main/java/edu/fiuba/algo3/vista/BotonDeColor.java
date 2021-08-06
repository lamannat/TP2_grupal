package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonColorEventHandler;
import edu.fiuba.algo3.modelo.color.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonDeColor extends Button {

    private Color color;

    public BotonDeColor(Color unColor){
        this.color = unColor;
        this.setText(color.getNombre());
        this.getStylesheets().add("estiloBotonColor.css");
        this.setStyle("-fx-text-fill: " + color.getColorText());
        this.setStyle("-fx-background-color: " + color.getCodigo() + ";-fx-text-fill:" + color.getColorText());
    }



    public void enAccion(BotonColorEventHandler eventHandler){
        eventHandler.setColor(color);
        this.setOnAction(eventHandler);
        eventHandler.setColorSeleccionado(this);
    }

    public void desactivar(String nombreJugador){
        this.setStyle("-fx-background-color: #373737");
        this.setTextFill(javafx.scene.paint.Color.WHITE);
        this.setText(nombreJugador);
        this.setOnAction(e -> {});
    }

    public Color getColor() {
        return color;
    }

}
