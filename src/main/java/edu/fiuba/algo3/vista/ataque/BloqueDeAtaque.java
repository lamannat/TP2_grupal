package edu.fiuba.algo3.vista.ataque;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class BloqueDeAtaque extends VBox implements Observer {

    private Juego juego;

    public BloqueDeAtaque(Juego juego) {

        BotonAtacar botonAtacar = new BotonAtacar(juego);
        DropDownDefensor paisQueSePuedeAtacar = new DropDownDefensor(juego, botonAtacar);
        DropDownAtacante paisParaAtacar = new DropDownAtacante(juego, paisQueSePuedeAtacar);

        Batalla batalla = juego.getBatalla();
        batalla.addObserver(paisParaAtacar);
        batalla.addObserver(paisQueSePuedeAtacar);
        juego.addObserverAPaises(paisParaAtacar);
        juego.addObserverAPaises(paisQueSePuedeAtacar);
        this.getChildren().addAll(paisParaAtacar, paisQueSePuedeAtacar,botonAtacar);
    }

    @Override
    public void change() {
    }

}