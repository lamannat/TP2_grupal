package edu.fiuba.algo3.vista.solicitar;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.BloqueAccion;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BloqueSolicitarCarta extends BloqueAccion {

    private Juego juego;

    public BloqueSolicitarCarta(Juego juego) {
        this.juego = juego;
        actualizar();
        this.setId("bloqueSolicitarCarta");
        this.getStyleClass().add("bloqueDeAccion");
    }

    public void actualizar() {

        BotonSolicitarCarta botonSolicitarCarta = new BotonSolicitarCarta(juego);
        botonSolicitarCarta.setVisible(false);

        Label estadoDeCarta = new Label("No conquisto\nen esta ronda");
        if (juego.jugadorActual().merecesCarta()) {
            estadoDeCarta.setText("Mereces carta\nyey :D");
            botonSolicitarCarta.setVisible(true);
        }

        Label cartaGanada = new Label();

        this.getChildren().clear();
        this.getChildren().addAll(estadoDeCarta, botonSolicitarCarta, cartaGanada);
    }

    public void setDropDown(Pais paisASetear){

        System.out.println("se recibio el pais en el bloque de pedir carta, pais: "+ paisASetear.toString()+ "\n");

        System.out.println("se completo el metodo en bloque de pedir carta");

    }

}
