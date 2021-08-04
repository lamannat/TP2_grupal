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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    Stage ventana;

    @Override
    public void start(Stage stage) {
        ventana = stage;
        
        SetUpJuego inicio = new SetUpJuego();

        ControladorDeEscena controladorDeEscena = new ControladorDeEscena(1280, 720);
        controladorDeEscena.agregarEscena(new VistaTitulo(new VBox(50), controladorDeEscena));
        controladorDeEscena.agregarEscena(new VistaSetearCantidadJugadores(new VBox(250), controladorDeEscena, inicio));
        VistaSetearNombresYColores vistaSetearNombresYColores = new VistaSetearNombresYColores(new VBox(250), controladorDeEscena, inicio);
        inicio.addObserver(vistaSetearNombresYColores);
        controladorDeEscena.agregarEscena(vistaSetearNombresYColores);

        VistaJuego vistaJuego = new VistaJuego(new BorderPane(), controladorDeEscena, inicio);
        controladorDeEscena.agregarEscena(vistaJuego);
        controladorDeEscena.agregarEscena(new VistaTerminoElJuego(new VBox(), controladorDeEscena, inicio));

        Escena sceneTitulo = controladorDeEscena.siguienteEscena();
        sceneTitulo.mostrar(ventana);

        ventana.setTitle("A.L.T.E.G.O");
        ventana.setFullScreen(false);
        ventana.setScene(sceneTitulo);

        ventana.show();
    }

    public static void main(String[] args) {
        launch();
    }

}