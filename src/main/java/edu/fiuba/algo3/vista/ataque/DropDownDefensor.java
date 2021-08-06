package edu.fiuba.algo3.vista.ataque;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import javafx.scene.control.ComboBox;

public class DropDownDefensor extends ComboBox implements Observer {

    private Pais paisAtacante;

    public DropDownDefensor(Juego juego, BotonAtacar botonEnviar){

        this.setPromptText("Defensor");

        this.setOnAction(e-> {

            Pais paisDefensor = juego.getPaisPorNombre((String)this.getValue());
            if (paisDefensor == null)
                return;

            botonEnviar.setPaisAtacanteYDefensor(paisAtacante,paisDefensor);
        });
    }

    public void setPaisAtacante(Pais pais){
        this.paisAtacante = pais;
    }

    @Override
    public void change() {
        this.getItems().clear();
    }
}
