package edu.fiuba.algo3.aplicacion.app;

import edu.fiuba.algo3.aplicacion.eventos.BotonSalirEventHandler;
import edu.fiuba.algo3.aplicacion.eventos.BotonComenzarEventHandler;
import edu.fiuba.algo3.aplicacion.eventos.PantallaNombresBotonAtrasEventHandler;
import edu.fiuba.algo3.modelo.SetupJuego;
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
    private int resolucionAlto = 720;
    private int resolucionAncho = 1280;
    Scene sceneTitulo, sceneCantJugadores, sceneNombresColores;
    Button botonVolver;

    @Override
    public void start(Stage stage) {

        ventana = stage;
        ventana.setTitle("A.L.T.E.G.O. - FIUBA");
        SetupJuego setup = new SetupJuego();
        VistaInicio vistainicio = new VistaInicio(this.ventana, this.resolucionAncho, this.resolucionAlto);
        Scene escena = new Scene(vistainicio);
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

    /*public void ingresarJugadores() {

        StackPane layout = new StackPane();

    }*/

    public Stage getStage() {
        return this.ventana;
    }
}