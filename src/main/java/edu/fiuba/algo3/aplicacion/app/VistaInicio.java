package edu.fiuba.algo3.aplicacion.app;

import edu.fiuba.algo3.aplicacion.eventos.BotonComenzarEventHandler;
import edu.fiuba.algo3.aplicacion.eventos.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaInicio extends StackPane {

    public VistaInicio(App app){
        super();
        Label titulo = new Label();
        Label integrantes = new Label();

        Button comenzar = new Button("Comenzar");
        Button salir = new Button("Salir");
        VBox contenedorVertical = new VBox();

        titulo.setText("A.L.T.E.G.O.\n" + "Trabajo Practico Nro. 2 \n" +  "Algoritmos y Programacion III - FIUBA");
        integrantes.setText("Integrantes: \n" + "\t- LEVI, Dolores\n" + "\t- LAMANNA, Tobías\n" + "\t- BIANCUZZO, Juan Ignacio\n" + "\t- SANTANDER, Valentín");

        StackPane.setAlignment(titulo, Pos.TOP_CENTER);
        StackPane.setAlignment(integrantes,Pos.BOTTOM_LEFT);

        salir.setOnAction(new BotonSalirEventHandler());

        comenzar.setOnAction(new BotonComenzarEventHandler(app));

        contenedorVertical.getChildren().addAll(comenzar,salir);
        contenedorVertical.setSpacing(20);
        contenedorVertical.setPadding(new Insets(240,0,0,50));

        this.setPrefWidth(app.getResolucionAncho());
        this.setPrefHeight(app.getResolucionAlto());
        this.getChildren().addAll(titulo, integrantes, contenedorVertical);
        this.setPadding(new Insets(10));
    }
}
