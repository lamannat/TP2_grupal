package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.SetUpJuego;
import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.scene.media.AudioClip;


import java.io.File;
import java.nio.file.Paths;

public class VistaTerminoElJuego extends Escena {

    private SetUpJuego setUp;
    private final VBox padre;
    private MediaPlayer player;

    public VistaTerminoElJuego(Parent padre, ControladorDeEscena controladorDeEscena, SetUpJuego setUp) {
        super(padre, controladorDeEscena);
        this.padre = (VBox) padre;
        this.setUp = setUp;
        Media media = new Media(Paths.get("src/main/resources/ganador.mp3").toUri().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.3);
        this.player = player;
    }

    @Override
    public void mostrar(Stage ventana) {
        this.player.play();

        Juego juego = this.setUp.dameJuego();
        Jugador jugador = juego.getJugadorGanador();

        padre.setPrefSize(1280, 720);

        Label felicidades = new Label("¡FELICIDADES!");
        felicidades.setTextFill(Color.valueOf(jugador.getColor().getColorText()));
        felicidades.setStyle("-fx-font-size: 150px");

        Label ganador = new Label(jugador.getNombre());
        ganador.setStyle("-fx-font-size: 130px");
        ganador.setTextFill(Color.valueOf(jugador.getColor().getColorText()));

        Label hasGanado = new Label("¡Has Ganado La Partida!");
        hasGanado.setStyle("-fx-font-size: 80px");
        hasGanado.setTextFill(Color.valueOf(jugador.getColor().getColorText()));

        HBox botones = new HBox(80);

        BotonSiguiente botonSiguiente = new BotonSiguiente(ventana, controladorDeEscena);
        botonSiguiente.setText("Volver a jugar");
        botonSiguiente.getStyleClass().add("botonVolverAJugar");

        BotonSalir botonSalir = new BotonSalir(ventana);

        botones.getChildren().addAll(botonSiguiente, botonSalir);
        botones.setAlignment(Pos.CENTER);

        padre.getChildren().clear();
        padre.getChildren().addAll(felicidades,ganador,hasGanado,botones);
        padre.setStyle("-fx-background-color: " + jugador.getColor().getCodigo());
        padre.setAlignment(Pos.CENTER);
        padre.setSpacing(30);
    }
}
