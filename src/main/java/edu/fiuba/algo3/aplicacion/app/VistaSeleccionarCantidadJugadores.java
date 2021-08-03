package edu.fiuba.algo3.aplicacion.app;

import edu.fiuba.algo3.aplicacion.eventos.PantallaNombresBotonAtrasEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class VistaSeleccionarCantidadJugadores extends StackPane {

    public VistaSeleccionarCantidadJugadores(Stage ventana, int resolucionAncho, int resolucionAlto){

        super();

        Label etiquetaIngreseCantidadDeJugadores = new Label();
        Button etiquetaNumero2 = new Button("2");
        Button etiquetaNumero3 = new Button("3");
        Button etiquetaNumero4 = new Button("4");
        Button etiquetaNumero5 = new Button("5");
        Button etiquetaNumero6 = new Button("6");
        Label etiquetaError= new Label();
        Button botonAtras = new Button("Atras");

        //LABEL INGRESE CANTIDAD
        etiquetaIngreseCantidadDeJugadores.setText("Ingrese cantidad de jugadores");
        etiquetaIngreseCantidadDeJugadores.setId("ingrese-label");

        //label error
        etiquetaError.setText("");
        etiquetaError.setId("error-label");

        //boton

        //VBOXCONTENEDOR
        VBox contenedor = new VBox();
        contenedor.setSpacing(5);

        //HBOX
        HBox contenedorNumeros = new HBox(etiquetaNumero2, etiquetaNumero3, etiquetaNumero4, etiquetaNumero5, etiquetaNumero6);
        HBox.setHgrow(contenedorNumeros, Priority.ALWAYS);

        HBox contenedorBoton = new HBox(etiquetaError, contenedorNumeros);
        contenedorBoton.setSpacing(0);

        //VBOX PRINCIPAL
        VBox contenedorPrincipal = new VBox(etiquetaIngreseCantidadDeJugadores,contenedorNumeros, contenedorBoton);
        contenedorPrincipal.setSpacing(15);
        contenedorPrincipal.setPadding(new Insets(20));
        contenedorPrincipal.setMaxHeight(200);
        contenedorPrincipal.setMaxWidth(350);
        contenedorPrincipal.setId("hbox");

        this.getChildren().addAll(contenedorPrincipal,botonAtras);
        this.setPadding(new Insets(10));

        //eventos

        botonAtras.setOnAction(new PantallaNombresBotonAtrasEventHandler(ventana));

        StackPane.setAlignment(this, Pos.CENTER );
        StackPane.setAlignment(botonAtras,Pos.BOTTOM_LEFT);

        this.setPrefWidth(resolucionAncho);
        this.setPrefHeight(resolucionAlto);

        Scene escena = new Scene(this);
        File estilo = new File ("src/main/java/edu/fiuba/algo3/aplicacion/css/name-screen.css");
        escena.getStylesheets().add(estilo.toURI().toString());
        ventana.setScene(escena);
    }
}
