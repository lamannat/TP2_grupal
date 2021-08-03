package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.ataque.BloqueDeAtaque;
import edu.fiuba.algo3.vista.incorporacion.BloqueDeIncorporacion;
import edu.fiuba.algo3.vista.movimiento.BloqueDeMovimiento;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class VistaJuego extends Escena {

    private final BorderPane padre;
    private final SetUpJuego setUp;

    public VistaJuego(Parent padre, ControladorDeEscena controladorDeEscena, SetUpJuego setUp) {
        super(padre, controladorDeEscena);
        this.padre = (BorderPane) padre;
        this.setUp = setUp;
    }

    public void mostrar(Stage ventana) {
        Juego juego = setUp.dameJuego();

        this.padre.setPrefWidth(controladorDeEscena.getResolucionAncho());
        this.padre.setPrefHeight(controladorDeEscena.getResolucionAlto());

        HBox estados = new HBox();
        estados.setStyle("-fx-background-color: " + juego.jugadorActual().getColor().getCodigo());
        Label estadoTitulo = new Label("Turno Jugador: " + juego.jugadorActual().getNombre());
        estadoTitulo.setScaleX(2);
        estadoTitulo.setScaleY(2);
        estadoTitulo.setTextFill(Color.BLACK);
        estados.getChildren().add(estadoTitulo);
        estados.setAlignment(Pos.CENTER);
        estados.setScaleX(3);
        estados.setScaleY(3);

        BloqueDeIncorporacion bloqueIncorporacion = new BloqueDeIncorporacion(juego);
//        BloqueDeAtaque bloqueDeAtaque = new BloqueDeAtaque(juego);
        BloqueDeMovimiento bloqueDeMovimiento = new BloqueDeMovimiento(juego);

        padre.setTop(estados);
        padre.setCenter(this.setearMapa());
//        padre.setRight(bloqueDeAtaque);
        padre.setRight(bloqueDeMovimiento);
        padre.setLeft(bloqueIncorporacion);


//        padre.setStyle("-fx-background-color: black");
    }

    private ImageView setearMapa(){
        File file = new File("src/main/java/edu/fiuba/algo3/archivos/mapaTEg.jpg");
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);

        return iv;
    }
}
