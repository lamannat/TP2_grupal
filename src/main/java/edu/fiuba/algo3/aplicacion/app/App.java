package edu.fiuba.algo3.aplicacion.app;

import edu.fiuba.algo3.aplicacion.eventos.BotonSalirEventHandler;
import edu.fiuba.algo3.aplicacion.eventos.BotonComenzarEventHandler;
import edu.fiuba.algo3.aplicacion.eventos.PantallaNombresBotonAtrasEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

/**
 * JavaFX App
 *
 */
public class App extends Application {

    private Stage ventana;
    private int resolucionAlto = 700;
    private int resolucionAncho = 1280;
    Scene sceneTitulo, sceneCantJugadores, sceneNombresColores;
    Button botonVolver;

    @Override
    public void start(Stage stage) {

        ventana = stage;

        ventana.setTitle("A.L.T.E.G.O. - FIUBA");
        StackPane layout = new StackPane();
        Label titulo = new Label();
        Label integrantes = new Label();

        Button comenzar = new Button("Comenzar");
        Button salir = new Button("Salir");
        VBox contenedorVertical = new VBox();

        Button botonVolver = new Button ("Volver");

        titulo.setText("A.L.T.E.G.O.\n" + "Trabajo Practico Nro. 2 \n" +  "Algoritmos y Programacion III - FIUBA");
        integrantes.setText("Integrantes: \n" + "\t- LEVI, Dolores\n" + "\t- LAMANNA, Tobías\n" + "\t- BIANCUZZO, Juan Ignacio\n" + "\t- SANTANDER, Valentín");

        StackPane.setAlignment(titulo,Pos.TOP_CENTER);
        StackPane.setAlignment(integrantes,Pos.BOTTOM_LEFT);

        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
        salir.setOnAction(botonSalirEventHandler);

        BotonComenzarEventHandler botonComenzarEventHandler = new BotonComenzarEventHandler(this);
        comenzar.setOnAction(botonComenzarEventHandler);

        contenedorVertical.getChildren().addAll(comenzar,salir);
        contenedorVertical.setSpacing(20);
        contenedorVertical.setPadding(new Insets(240,0,0,50));

        layout.setPrefWidth(this.resolucionAncho);
        layout.setPrefHeight(this.resolucionAlto);
        layout.getChildren().addAll(titulo, integrantes, contenedorVertical);
        layout.setPadding(new Insets(10));

        Scene escena = new Scene(layout);
        ventana.setFullScreen(false);
        File estilo = new File ("src/main/java/edu/fiuba/algo3/aplicacion/css/start-screen.css");
        escena.getStylesheets().add(estilo.toURI().toString());
        ventana.setScene(escena);
        ventana.resizableProperty().setValue(Boolean.FALSE);

        ventana.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void ingresarJugadores() {

        StackPane layout = new StackPane();
        Label etiquetaIngreseCantidadDeJugadores = new Label();
        Button etiquetaNumero2 = new Button("2");
        Button etiquetaNumero3 = new Button("3");
        Button etiquetaNumero4 = new Button("4");
        Button etiquetaNumero5 = new Button("5");
        Button etiquetaNumero6 = new Button("6");
        Label etiquetaError= new Label();
        Button botonAtras = new Button("Atras");

        //LABEL INGRESE NOMBRES
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

        layout.getChildren().addAll(contenedorPrincipal,botonAtras);
        layout.setPadding(new Insets(10));

        //eventos

        PantallaNombresBotonAtrasEventHandler e = new PantallaNombresBotonAtrasEventHandler(this);
        botonAtras.setOnAction(e);
        botonAtras.defaultButtonProperty().bind(botonAtras.focusedProperty());


        StackPane.setAlignment(layout, Pos.CENTER );
        StackPane.setAlignment(botonAtras,Pos.BOTTOM_LEFT);

        layout.setPrefWidth(this.resolucionAncho);
        layout.setPrefHeight(this.resolucionAlto);

        Scene escena = new Scene(layout);
        File estilo = new File ("src/main/java/edu/fiuba/algo3/aplicacion/css/name-screen.css");
        escena.getStylesheets().add(estilo.toURI().toString());
        ventana.setScene(escena);
    }

    public Stage getStage() {
        return this.ventana;
    }
}