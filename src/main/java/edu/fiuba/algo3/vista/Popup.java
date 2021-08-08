package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ListenerVentanaDesenfocada;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Popup extends Stage {

    public Popup(Scene nuevaEscena, Stage ventanaPrincipal){

        // New window (Stage)
        this.setScene(nuevaEscena);

        this.initStyle(StageStyle.UNDECORATED);
        this.setX(ventanaPrincipal.getX() + 415 );
        this.setY(ventanaPrincipal.getY() + 260 );

        this.focusedProperty().addListener(new ListenerVentanaDesenfocada(this));

        this.show();
    }
}
