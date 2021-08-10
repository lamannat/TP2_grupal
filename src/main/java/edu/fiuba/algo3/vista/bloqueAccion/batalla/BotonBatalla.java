package edu.fiuba.algo3.vista.bloqueAccion.batalla;

import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.Popup;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonBatalla extends Button {

    private Integer cantFichas = null;

    public BotonBatalla(Pais paisDefensor, Pais paisAtacante, Stage ventana){
        this.setText("Mover Tropas");

        this.setOnAction(e -> {
            if (cantFichas == null)
                return;
            paisAtacante.moverTropas(paisDefensor,cantFichas);
            ventana.close();
            cantFichas = null;
        });
    }

    public void setCantidadDeFichas(int cantidadDeFichas) {
        this.cantFichas = cantidadDeFichas;
    }
}
