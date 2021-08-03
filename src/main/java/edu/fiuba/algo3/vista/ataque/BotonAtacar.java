package edu.fiuba.algo3.vista.ataque;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.control.Button;

public class BotonAtacar extends Button {

    private Pais paisAtacante;
    private Pais paisDefensor;

    public BotonAtacar(Juego juego){
        this.setText("Atacar");

        this.setOnAction(e-> {
            try {
                paisAtacante.paisAtacaAPais(paisDefensor,juego.getBatalla());
            } catch (FichasInsuficientesException fic) {
                fic.printStackTrace();
            } catch (NoEsLimitrofeException lim) {
                lim.printStackTrace();
            } catch (AtaqueAPaisAliadoException at) {
                at.printStackTrace();
            }
        });
    }

    public void setPaisAtacanteYDefensor(Pais paisAtacante, Pais paisDefensor) {
        this.paisAtacante = paisAtacante;
        this.paisDefensor = paisDefensor;
    }
}
