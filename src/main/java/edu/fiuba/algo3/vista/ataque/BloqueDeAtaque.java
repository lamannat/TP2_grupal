package edu.fiuba.algo3.vista.ataque;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.BloqueAccion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class BloqueDeAtaque extends BloqueAccion {

    private Juego juego;

    public BloqueDeAtaque(Juego juego) {
        this.juego = juego;
        actualizar();
    }

    @Override
    public void change() {
    }

    public void actualizar() {
        BotonAtacar botonAtacar = new BotonAtacar(juego);
        DropDownDefensor paisQueSePuedeAtacar = new DropDownDefensor(juego, botonAtacar);
        DropDownAtacante paisParaAtacar = new DropDownAtacante(juego, paisQueSePuedeAtacar);

        Batalla batalla = juego.getBatalla();
        batalla.addObserver(paisParaAtacar);
        batalla.addObserver(paisQueSePuedeAtacar);
        juego.addObserverAPaises(paisParaAtacar);
        juego.addObserverAPaises(paisQueSePuedeAtacar);

        this.getChildren().clear();
        this.getChildren().addAll(paisParaAtacar, paisQueSePuedeAtacar,botonAtacar);
    }
}