package edu.fiuba.algo3.vista.movimiento;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.vista.BloqueAccion;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class BloqueDeMovimiento extends BloqueAccion {

    private Juego juego;

    public BloqueDeMovimiento (Juego juego) {
        this.juego = juego;
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(20);
        actualizar();
    }

    @Override
    public void change() {

    }

    public void actualizar() {
        BotonMoverTropas moverTropas = new BotonMoverTropas(juego);
        moverTropas.setText("Mover tropas");
        DropDownPaisDestino paisDestino = new DropDownPaisDestino(juego, moverTropas);
        DropDownCantidadFichas cantidadFichas = new DropDownCantidadFichas(moverTropas);
        DropDownPaisElegido paisElegido = new DropDownPaisElegido(juego, paisDestino, cantidadFichas, moverTropas);

        juego.jugadorActual().addObserver(cantidadFichas);
        juego.jugadorActual().addObserver(paisElegido);
        juego.jugadorActual().addObserver(paisDestino);

        Label labelPaisDeOrigen = new Label("Desde:");
        Label labelPaisDestino = new Label("Hacia:");
        Label labelCantTropas = new Label("Mover fichas:");
        labelPaisDeOrigen.setTextFill(Color.WHITE);
        labelPaisDestino.setTextFill(Color.WHITE);
        labelCantTropas.setTextFill(Color.WHITE);
        labelPaisDeOrigen.setStyle("-fx-font-weight: bold");
        labelPaisDestino.setStyle("-fx-font-weight: bold");
        labelCantTropas.setStyle("-fx-font-weight: bold");

        this.getChildren().addAll(labelCantTropas,labelPaisDeOrigen,labelPaisDestino);

        this.getChildren().clear();
        this.getChildren().addAll(labelCantTropas,cantidadFichas,labelPaisDeOrigen,paisElegido, labelPaisDestino,paisDestino, moverTropas);
    }
}
