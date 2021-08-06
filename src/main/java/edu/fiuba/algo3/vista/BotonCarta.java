package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ListenerVentanaDesenfocada;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.cartas.Carta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;

public class BotonCarta extends Button {

    private List<VistaCarta> cartas;
    private Juego juego;
//    String listaObjetivos = "Esto no son los objetivos o.0";

    public BotonCarta(Stage ventana, Juego juego) {
        this.juego = juego;
        this.cartas = new ArrayList<>();

        Image img = new Image("logo_dar_carta.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(50);
        view.setFitWidth(50);
        view.setPreserveRatio(true);
        this.setGraphic(view);

        this.setOnAction(e -> {

            this.actualizar();

            TilePane layout = new TilePane();
            layout.setStyle("-fx-background-color: #272727");
            layout.getChildren().addAll(cartas);

            Scene nuevaEscena = new Scene(layout, 450,300);

            // New window (Stage)
            Stage nuevaVentana = new Stage();
            nuevaVentana.setScene(nuevaEscena);

            nuevaVentana.initStyle(StageStyle.UNDECORATED);
            nuevaVentana.setX(ventana.getX() + 415 );
            nuevaVentana.setY(ventana.getY() + 260 );

            nuevaVentana.focusedProperty().addListener(new ListenerVentanaDesenfocada(nuevaVentana));

            nuevaVentana.show();
        });

    }

    public void actualizar() {
        this.cartas = new ArrayList<>();
        for (Carta carta : juego.jugadorActual().getCartas())
            cartas.add(new VistaCarta(carta));
    }
}
