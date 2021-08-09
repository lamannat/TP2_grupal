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

import java.io.File;

public class VistaTerminoElJuego extends Escena {

    private SetUpJuego setUp;
    private final VBox padre;

    public VistaTerminoElJuego(Parent padre, ControladorDeEscena controladorDeEscena, SetUpJuego setUp) {
        super(padre, controladorDeEscena);
        this.padre = (VBox) padre;
        this.setUp = setUp;
    }

    @Override
    public void mostrar(Stage ventana) {
        Juego juego = this.setUp.dameJuego();
        Jugador jugador = juego.getJugadorGanador();

        padre.setPrefSize(1280, 720);

        Label ganador = new Label(jugador.getNombre());
        ganador.setStyle("-fx-font-size: 30");
        ganador.setTextFill(Color.valueOf(jugador.getColor().getColorText()));

        Label subTitulo = new Label("yey");
        subTitulo.setTextFill(Color.valueOf(jugador.getColor().getColorText()));

        File file = new File("src/main/java/edu/fiuba/algo3/archivos/Ganastesss.png");
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView();
        iv.setPreserveRatio(false);
        iv.setImage(image);

        HBox cajaFinal = new HBox();

        BotonSiguiente botonSiguiente = new BotonSiguiente(ventana, controladorDeEscena);
        botonSiguiente.setText("Volver a jugar");
        Button botonExit = new Button("Salir");
        botonExit.setOnAction(e -> {
            ventana.close();
        });

        cajaFinal.getChildren().addAll(botonSiguiente, botonExit);
        cajaFinal.setAlignment(Pos.CENTER);

        padre.getChildren().clear();
        padre.getChildren().addAll(ganador, iv, subTitulo, cajaFinal);
        padre.setStyle("-fx-background-color: " + jugador.getColor().getCodigo());
        padre.setAlignment(Pos.CENTER);

    }
}
