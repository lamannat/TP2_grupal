package edu.fiuba.algo3.vista.bloqueAccion.ataque;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.bloqueAccion.batalla.VistaBatalla;
import javafx.scene.control.Button;

public class BotonAtacar extends Button {

    private Pais paisAtacante;
    private Pais paisDefensor;

    public BotonAtacar(Juego juego){
        this.setText("Atacar");
        resetear();

        this.setOnAction(e-> {
            if (paisAtacante == null || paisDefensor == null)
                return;

            VistaBatalla vistaBatalla = new VistaBatalla(paisAtacante,paisDefensor);
            paisDefensor.addObserver(vistaBatalla);

            try {
                paisAtacante.paisAtacaAPais(paisDefensor,juego.getBatalla());
            } catch (FichasInsuficientesException | NoEsLimitrofeException | AtaqueAPaisAliadoException ignored) {}

            paisDefensor.removeObserver(vistaBatalla);

            resetear();
        });
    }

    private void resetear() {
        paisAtacante = null;
        paisDefensor = null;
    }

    public void setPaisAtacante(Pais paisAtacante) {
        this.paisAtacante = paisAtacante;
    }

    public void setPaisDefensor(Pais paisDefensor) {
        this.paisDefensor = paisDefensor;
    }
}
