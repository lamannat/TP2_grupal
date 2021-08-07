package edu.fiuba.algo3.vista.bloqueAccion.ataque;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.batalla.VistaBatalla;
import javafx.scene.control.Button;

public class BotonAtacar extends Button {

    private Pais paisAtacante = null;
    private Pais paisDefensor = null;

    public BotonAtacar(Juego juego){
        this.setText("Atacar");

        this.setOnAction(e-> {
            if (paisAtacante == null || paisDefensor == null)
                return;

            VistaBatalla vistaBatalla = new VistaBatalla(paisAtacante,paisDefensor);
            paisDefensor.addObserver(vistaBatalla);

            try {
                paisAtacante.paisAtacaAPais(paisDefensor,juego.getBatalla());
            } catch (FichasInsuficientesException | NoEsLimitrofeException | AtaqueAPaisAliadoException ignored) {}

            paisDefensor.removeObserver(vistaBatalla);
        });
    }

    public void setPaisAtacanteYDefensor(Pais paisAtacante, Pais paisDefensor) {
        this.paisAtacante = paisAtacante;
        this.paisDefensor = paisDefensor;
    }

    public void setPaisAtacante(Pais paisAtacante) {
        this.paisAtacante = paisAtacante;
    }

    public void setPaisDefensor(Pais paisDefensor) {
        this.paisDefensor = paisDefensor;
    }
}
