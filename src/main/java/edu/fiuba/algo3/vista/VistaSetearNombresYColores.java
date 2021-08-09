package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.SetUpJuego;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Observer;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;

public class VistaSetearNombresYColores extends Escena implements Observer {

    private final VBox padre;
    private int cantJugadores;
    private final SetUpJuego setUp;

    public VistaSetearNombresYColores(Parent padre, ControladorDeEscena controladorDeEscena, SetUpJuego setUp) {
        super(padre, controladorDeEscena);
        this.padre = (VBox) padre;
        this.setUp = setUp;
    }

    public void mostrar(Stage ventana) {
        padre.getChildren().clear();

        this.padre.setPrefWidth(controladorDeEscena.getResolucionAncho());
        this.padre.setPrefHeight(controladorDeEscena.getResolucionAlto());

        BotonSiguiente botonSiguienteEscena = new BotonSiguiente(ventana, this.controladorDeEscena);
        botonSiguienteEscena.setVisible(false);

        HBox hboxTexto = new HBox();
        hboxTexto.setStyle("-fx-background-color: #272727");

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el nombre del Jugador");
        texto.setStyle("-fx-font-size: 30px;");

        Label label = new Label();
        label.setTextFill(Color.WHITE);
        label.setStyle("-fx-font-size: 40px;");

        Button botonSiguiente = new Button();
        botonSiguiente.setText("Siguiente Jugador");
        botonSiguiente.getStyleClass().addAll("botonSiguienteJugador");

        ArrayList<Pair<String,BotonDeColor>> listaNombreYBoton = new ArrayList<>();

        botonSiguiente.setOnAction(new BotonSiguienteJugadorEventHandler(listaNombreYBoton, texto, label, cantJugadores, botonSiguienteEscena, setUp));

        hboxTexto.setSpacing(120.0);
        hboxTexto.setAlignment(Pos.CENTER);
        hboxTexto.getChildren().addAll(texto,botonSiguiente);
        HBox hboxColores = new HBox();
        hboxColores.setStyle("-fx-background-color: #272727");

        BotoneraColores botoneraColores = new BotoneraColores(texto,label,listaNombreYBoton);

        padre.setAlignment(Pos.CENTER);
        padre.setSpacing(80.0);
        padre.getChildren().addAll(hboxTexto, botoneraColores, label, botonSiguienteEscena);
        padre.setMinSize(110.0,110.0);
        padre.setStyle("-fx-background-color: #272727");
    }

    @Override
    public void change() {
        cantJugadores = setUp.getCantidadJugadores();
    }
}
