package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.cartas.Carta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class BotonCarta extends Button {

    private List<VistaCarta> cartas;
    private final Juego juego;

    public BotonCarta(Stage ventana, Juego juego) {
        this.juego = juego;
        this.cartas = new ArrayList<>();

        Tooltip unTooltip = new Tooltip("Cartas País");
        unTooltip.setShowDelay(Duration.millis(10));
        this.setTooltip(unTooltip);
        this.getStyleClass().addAll("botonFoto", "hoverOscuro");

        Image img = new Image("imagenes/logo_dar_carta.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(50);
        view.setFitWidth(50);
        view.setPreserveRatio(true);
        this.setGraphic(view);

        this.setOnAction(e -> {

            this.actualizar();

            TilePane layout = new TilePane();
            layout.getChildren().addAll(cartas);
            layout.setHgap(30);
            layout.setVgap(20);

            layout.setAlignment(Pos.CENTER);

            layout.setStyle("-fx-background-color: #272727;" +
                    "-fx-border-color: #ffcc3d;\n" +
                    "-fx-border-style: solid;\n" +
                    "-fx-border-width: 5;");

            //Popup
            Popup popup = new Popup(layout);
            popup.setDimensiones(530,400);
            popup.setDistanciaAPrincipal(ventana.getX() + ventana.getWidth()/2 - 265,ventana.getY() +  ventana.getHeight()/2 - 200);
            popup.crearPopup();
        });

    }

    public void actualizar() {
        this.cartas = new ArrayList<>();
        for (Carta carta : juego.jugadorActual().getCartas())
            cartas.add(new VistaCarta(carta));
    }
}