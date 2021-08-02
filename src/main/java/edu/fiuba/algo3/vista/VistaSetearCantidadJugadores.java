package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonCantidadEventHandler;
import edu.fiuba.algo3.controlador.BotonSiguienteEscenaEventHandler;
import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.SetUpJuego;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VistaSetearCantidadJugadores extends Escena {

    private final VBox padre;
    private final SetUpJuego setUp;

    public VistaSetearCantidadJugadores(Parent padre, ControladorDeEscena controladorDeEscena, SetUpJuego setUp) {
        super(padre, controladorDeEscena);
        this.padre = (VBox) padre;
        this.setUp = setUp;
    }

    public void mostrar(Stage ventana) {
        padre.getChildren().clear();

        BotonSiguiente botonSiguiente = new BotonSiguiente(ventana, this.controladorDeEscena);
        botonSiguiente.setVisible(false);

        BotoneraCantidadJugadores botonera = new BotoneraCantidadJugadores(botonSiguiente, setUp);

//        VBox vbox = new VBox();
        padre.setStyle("-fx-background-color: #272727");
        padre.setAlignment(Pos.CENTER);
        padre.setSpacing(200.0);

        Label textoCantidadJugadores = new Label("¿Cuántos juegan?");
        textoCantidadJugadores.setScaleX(10);
        textoCantidadJugadores.setScaleY(10);
        textoCantidadJugadores.setTextFill(Color.YELLOW);

        padre.getChildren().addAll(textoCantidadJugadores, botonera, botonSiguiente);
    }
}
