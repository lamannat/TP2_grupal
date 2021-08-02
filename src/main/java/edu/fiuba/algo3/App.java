package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.moduloRonda.Turno;
import edu.fiuba.algo3.vista.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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

//        // BOTON VOLVER
//        botonVolver = new Button("VOLVER");
//        botonVolver.setOnAction(e -> ventana.setScene(sceneTitulo));
//        botonVolver.setAlignment(Pos.CENTER);
//        botonVolver.setScaleX(2);
//        botonVolver.setScaleY(2);
//        botonVolver.setStyle("-fx-background-color: black");
//        botonVolver.setTextFill(Color.WHITE);
//
//        BorderPane pane = new BorderPane();
//        pane.setCenter(botonVolver);
//
//        Scene sceneVolver = new Scene(pane);

//        VistaSetearNombresYColores nombresYColores = new VistaSetearNombresYColores();
//        Scene sceneNombresColores =  nombresYColores.crearJugadores(ventana,sceneVolver);
//
//        VistaSetearCantidadJugadores cantJugadores = new VistaSetearCantidadJugadores();
//        Scene sceneCantJugadores = cantJugadores.crearCantJugadores(ventana,sceneNombresColores);

//        VBox padre = new VBox();

        SetUpJuego inicio = new SetUpJuego();

        ControladorDeEscena controladorDeEscena = new ControladorDeEscena();
        controladorDeEscena.agregarEscena(new VistaTitulo(new VBox(50), controladorDeEscena));
        controladorDeEscena.agregarEscena(new VistaSetearCantidadJugadores(new VBox(250), controladorDeEscena, inicio));
        VistaSetearNombresYColores vistaSetearNombresYColores = new VistaSetearNombresYColores(new VBox(250), controladorDeEscena, inicio);
        inicio.addObserver(vistaSetearNombresYColores);
        controladorDeEscena.agregarEscena(vistaSetearNombresYColores);

        VistaJuego vistaJuego = new VistaJuego(new VBox(250), controladorDeEscena, inicio);
        controladorDeEscena.agregarEscena(vistaJuego);

        Escena sceneTitulo = controladorDeEscena.siguienteEscena();
        sceneTitulo.mostrar(ventana);

        ventana.setTitle("A.L.T.E.G.O");
        ventana.setScene(sceneTitulo);
        ventana.setMaximized(true);

        ventana.show();
    }

    public static void main(String[] args) {
        launch();
    }

}