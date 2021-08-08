package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ListenerVentanaDesenfocada;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.cartas.Carta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class BotonCarta extends Button {

    private List<VistaCarta> cartas;
    private Juego juego;
//    String listaObjetivos = "Esto no son los objetivos o.0";

    public BotonCarta(Stage ventana, Juego juego) {
        this.juego = juego;
        this.cartas = new ArrayList<>();

        Tooltip unTooltip = new Tooltip("Cartas País");
        unTooltip.setShowDelay(Duration.millis(10));
        this.setTooltip(unTooltip);
        this.getStyleClass().addAll("botonFoto", "hoverOscuro");

        Image img = new Image("logo_dar_carta.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(50);
        view.setFitWidth(50);
        view.setPreserveRatio(true);
        this.setGraphic(view);

        this.setOnAction(e -> {

            this.actualizar();

            TilePane layout = new TilePane();
            layout.getChildren().addAll(cartas);
            layout.setHgap(10);
            layout.setVgap(10);

//            Scene nuevaEscena = new Scene(layout, 775,200);

            layout.setStyle("-fx-background-color: #272727;" +
                    "-fx-border-color: #ffcc3d;\n" +
                    "-fx-border-style: solid;\n" +
                    "-fx-border-width: 5;");

            //Popup
            Popup popup = new Popup(layout);
            popup.setDimensiones(775,200);
            popup.setDistanciaAPrincipal(ventana.getX() + 190,ventana.getY() + 270);
            popup.crearPopup();


            // New window (Stage)
//            Stage nuevaVentana = new Stage();
//            nuevaVentana.setScene(nuevaEscena);
//
//            nuevaVentana.initStyle(StageStyle.UNDECORATED);
//            nuevaVentana.setX(ventana.getX() + 190 );
//            nuevaVentana.setY(ventana.getY() + 270 );
//
//            nuevaVentana.focusedProperty().addListener(new ListenerVentanaDesenfocada(nuevaVentana));
//
//            nuevaVentana.show();
        });

    }

    public void actualizar() {
        this.cartas = new ArrayList<>();
        for (Carta carta : juego.jugadorActual().getCartas())
            cartas.add(new VistaCarta(carta));
    }
}
