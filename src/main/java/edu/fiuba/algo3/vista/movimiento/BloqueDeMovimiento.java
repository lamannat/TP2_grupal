package edu.fiuba.algo3.vista.movimiento;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.BloqueAccion;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BloqueDeMovimiento extends BloqueAccion {

    private Juego juego;

    public BloqueDeMovimiento (Juego juego) {
        this.juego = juego;
        actualizar();
        this.setId("bloqueDeMovimiento");
        this.getStyleClass().add("bloqueDeAccion");
    }

    @Override
    public void change() {
        actualizar();
    }

    public void actualizar() {
        BotonMoverTropas moverTropas = new BotonMoverTropas(juego);
        moverTropas.setText("Mover tropas");
        DropDownPaisDestino paisDestino = new DropDownPaisDestino(juego, moverTropas);
        DropDownCantidadFichas cantidadFichas = new DropDownCantidadFichas(moverTropas);
        DropDownPaisElegido paisElegido = new DropDownPaisElegido(juego, paisDestino, cantidadFichas, moverTropas);
        Label labelDestino = new Label("Elegi pais a donde\nmover fichas");
        Label labelFichas = new Label("Elegi n° de Fichas");
        Label labelElegido = new Label("Elegi pais a cual\nsacarle fichas");

        juego.jugadorActual().addObserver(cantidadFichas);
        juego.jugadorActual().addObserver(paisElegido);
        juego.jugadorActual().addObserver(paisDestino);

        this.getChildren().clear();
        this.getChildren().addAll(labelElegido,paisElegido, labelFichas,cantidadFichas, labelDestino,paisDestino, moverTropas);
    }

    public void setDropDown(Pais paisASetear){

        System.out.println("se recibio el pais en el bloque de reagrupacion, pais: "+ paisASetear.toString()+ "\n");

        System.out.println("se completo el metodo en bloque de reagrupacion");

    }
}
