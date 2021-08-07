package edu.fiuba.algo3.vista.batalla;

import edu.fiuba.algo3.modelo.Pais;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonBatalla extends Button {

    private Integer cantFichas =null;

    public BotonBatalla(Pais paisDefensor, Pais paisAtacante, Stage nuevaVentana){

        this.setText("Mover Tropas");
        this.setOnAction(e -> {
            if (cantFichas == null)
                return;
            paisAtacante.moverTropas(paisDefensor,cantFichas);
            nuevaVentana.close();
        });
    }

    public void setCantidadDeFichas(int cantidadDeFichas) {
        this.cantFichas = cantidadDeFichas;
    }
}
