package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonCantidadEventHandler;
import edu.fiuba.algo3.controlador.BotonSiguienteEscenaEventHandler;
import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.Juego;
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

    public VistaSetearCantidadJugadores(Parent padre, ControladorDeEscena controladorDeEscena, Juego juego) {
        super(padre, controladorDeEscena, juego);
        this.padre = (VBox) padre;
    }

    public void mostrar(Stage ventana) {
        padre.getChildren().clear();

        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: #272727");

        BotonSiguiente botonSiguiente = new BotonSiguiente(ventana, this.controladorDeEscena);
        botonSiguiente.setVisible(false);

        Button boton2 = new Button("2");
        Button boton3 = new Button("3");
        Button boton4 = new Button("4");
        Button boton5 = new Button("5");
        Button boton6 = new Button("6");

        boton2.setScaleX(3);
        boton2.setScaleY(3);
        boton3.setScaleX(3);
        boton3.setScaleY(3);
        boton4.setScaleX(3);
        boton4.setScaleY(3);
        boton5.setScaleX(3);
        boton5.setScaleY(3);
        boton6.setScaleX(3);
        boton6.setScaleY(3);

        boton2.setStyle("-fx-background-color: black");
        boton2.setTextFill(Color.WHITE);
        boton2.setAlignment(Pos.CENTER);

        boton3.setStyle("-fx-background-color: black");
        boton3.setTextFill(Color.WHITE);
        boton3.setAlignment(Pos.CENTER);

        boton4.setStyle("-fx-background-color: black");
        boton4.setTextFill(Color.WHITE);
        boton4.setAlignment(Pos.CENTER);

        boton5.setStyle("-fx-background-color: black");
        boton5.setTextFill(Color.WHITE);
        boton5.setAlignment(Pos.CENTER);

        boton6.setStyle("-fx-background-color: black");
        boton6.setTextFill(Color.WHITE);
        boton6.setAlignment(Pos.CENTER);


        boton2.setOnAction(new BotonCantidadEventHandler(2, juego, botonSiguiente));
        boton3.setOnAction(new BotonCantidadEventHandler(3, juego, botonSiguiente));
        boton4.setOnAction(new BotonCantidadEventHandler(4, juego, botonSiguiente));
        boton5.setOnAction(new BotonCantidadEventHandler(5, juego, botonSiguiente));
        boton6.setOnAction(new BotonCantidadEventHandler(6, juego, botonSiguiente));


        hbox.setSpacing(200.0);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(boton2,boton3,boton4,boton5,boton6);

//        VBox vbox = new VBox();
        padre.setStyle("-fx-background-color: #272727");
        padre.setAlignment(Pos.CENTER);
        padre.setSpacing(200.0);

        Label textoCantidadJugadores = new Label("¿Cuántos juegan?");
        textoCantidadJugadores.setScaleX(10);
        textoCantidadJugadores.setScaleY(10);
        textoCantidadJugadores.setTextFill(Color.YELLOW);

        padre.getChildren().addAll(textoCantidadJugadores,hbox, botonSiguiente);
    }
}
