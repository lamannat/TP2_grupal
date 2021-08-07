package edu.fiuba.algo3.vista.ataque;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.BloqueAccion;
import javafx.scene.control.Label;

public class BloqueDeAtaque extends BloqueAccion {

    private Juego juego;

    public BloqueDeAtaque(Juego juego) {
        this.juego = juego;
        actualizar();
        this.setId("bloqueDeAtaque");
    }

    @Override
    public void change() {
         actualizar();
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

        Label labelPaisAtacar = new Label("Elija pais\ncon cual atacar");
        Label labelPaisDefensor = new Label("Elija pais\na cual atacar");



        this.getChildren().clear();
        this.getChildren().addAll(labelPaisAtacar,paisParaAtacar,labelPaisDefensor, paisQueSePuedeAtacar,botonAtacar);
    }
}