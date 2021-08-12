package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class BarraDeEstado extends HBox implements Observer {

    private final Juego juego;

    public BarraDeEstado(Juego juego) {
        this.juego = juego;
        this.actualizar();
    }

    @Override
    public void change() {
        this.actualizar();
    }

    public void actualizar() {
        this.setPrefSize(1280, 90);
        this.setMinSize(1280, 90);
        this.setMaxSize(1280, 90);

        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: " + juego.jugadorActual().getColor().getCodigo() + "; -fx-font-size: 30");
        this.setSpacing(50);

        Label estadoTitulo = new Label("Turno Jugador: " + juego.jugadorActual().getNombre());
        estadoTitulo.setTextFill(Color.valueOf(juego.jugadorActual().getColor().getColorText()));
        estadoTitulo.setMinWidth(640);
        estadoTitulo.setMaxWidth(640);
        estadoTitulo.setPrefWidth(640);
        estadoTitulo.setAlignment(Pos.CENTER);

        HBox bloqueDerecha = new HBox();

        Label faseActual = new Label("Fase para " + juego.dameRonda().dameFase().ID());
        faseActual.setTextFill(Color.valueOf(juego.jugadorActual().getColor().getColorText()));
        bloqueDerecha.setAlignment(Pos.CENTER);
        bloqueDerecha.getChildren().add(faseActual);

        bloqueDerecha.setMinWidth(640);
        bloqueDerecha.setMaxWidth(640);
        bloqueDerecha.setPrefWidth(640);

        this.getChildren().clear();
        this.getChildren().addAll(estadoTitulo, bloqueDerecha);
    }
}
