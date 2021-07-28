package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    Stage ventana;
    Scene sceneTitulo, sceneCantJugadores, sceneNombresColores;
    Button botonVolver;

    @Override
    public void start(Stage stage) {
        ventana = stage;

        // BOTON VOLVER
        botonVolver = new Button("VOLVER");
        botonVolver.setOnAction(e -> ventana.setScene(sceneTitulo));
        botonVolver.setAlignment(Pos.CENTER);
        botonVolver.setScaleX(2);
        botonVolver.setScaleY(2);
        botonVolver.setStyle("-fx-background-color: black");
        botonVolver.setTextFill(Color.WHITE);

        BorderPane pane = new BorderPane();
        pane.setCenter(botonVolver);

        Scene sceneVolver = new Scene(pane);

        NombresYColores nombresYColores = new NombresYColores();
        Scene sceneNombresColores =  nombresYColores.crearJugadores(ventana,sceneVolver);

        CantidadJugadores cantJugadores = new CantidadJugadores();
        Scene sceneCantJugadores = cantJugadores.crearCantJugadores(ventana,sceneNombresColores);

        Titulo titulo = new Titulo();
        sceneTitulo = titulo.crearTitulo(ventana, sceneCantJugadores);

        ventana.setTitle("A.L.T.E.G.O");
        ventana.setScene(sceneTitulo);
        ventana.setMaximized(true);

        ventana.show();


    }

    public static void main(String[] args) {
        launch();
    }

}