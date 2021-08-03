package edu.fiuba.algo3.aplicacion.app;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class VistaIngresarJugadores extends StackPane {



    public VistaIngresarJugadores(App app, int cantidad){
        super();

        VBox contenedorPrincipal = new VBox();
        for(int i = 0; i < cantidad; i++){
            Label etiquetaJugadorI = new Label();
            etiquetaJugadorI.setText("Jugador " + (i+1) +":");
            TextField textoJugadorI = new TextField();
            textoJugadorI.setPromptText("Jugador " + (i+1) +":");
            VBox contenedorJugadorI = new VBox(etiquetaJugadorI,textoJugadorI);
            contenedorJugadorI.setSpacing(5);
            contenedorPrincipal.getChildren().addAll(contenedorJugadorI);
        }

        this.setPrefWidth(app.getResolucionAncho());
        this.setPrefHeight(app.getResolucionAlto());
        this.getChildren().addAll(contenedorPrincipal);
        this.setPadding(new Insets(10));


    }

}
